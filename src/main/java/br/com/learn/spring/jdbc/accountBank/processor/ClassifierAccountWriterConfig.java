package br.com.learn.spring.jdbc.accountBank.processor;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Account;

@Configuration
public class ClassifierAccountWriterConfig {
	@Bean
	public ClassifierCompositeItemWriter<Account> classifierAccountWriter(
			@Qualifier("clientInvalidWriter")FlatFileItemWriter<Account> clientInvalidWriter,
			CompositeItemWriter<Account> clientValidoWriter){
		return new ClassifierCompositeItemWriterBuilder<Account>()
				.classifier(classifier(clientInvalidWriter, clientValidoWriter))
				.build();
	}

	@SuppressWarnings("serial")
	private Classifier<Account, ItemWriter<? super Account>> classifier(
			FlatFileItemWriter<Account> clientInvalidWriter,
			CompositeItemWriter<Account> clientValidoWriter) {
		return new Classifier<Account, ItemWriter<? super Account>>() {
			
			@Override
			public ItemWriter<? super Account> classify(Account account) {
				if(account.getType() != null) 
					return clientValidoWriter;
				else 
					return clientInvalidWriter;
			}
		};
	}
}
