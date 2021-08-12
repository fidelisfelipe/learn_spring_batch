package br.com.learn.spring.jdbc.accountBank.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Account;
import br.com.learn.spring.comum.model.Client;

@Configuration
public class GeneratorAccountProcessorConfig {

	@Bean
	public ItemProcessor<Client, Account> generatorAccountProcessor(){
		return new ClassifierCompositeItemProcessorBuilder<Client, Account>()
				.classifier(new GeneratorAccountClassifier())
				.build();
	}
}
