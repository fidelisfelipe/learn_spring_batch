package br.com.learn.spring.file.classifier.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class ClassifierProcessorConfig {
	@SuppressWarnings("rawtypes")
	@Bean
	public ItemProcessor processadorClassifierProcessor() {
		return new ClassifierCompositeItemProcessorBuilder()
				.classifier(classifier())
				.build();
	}

	private Classifier classifier() {
		return new Classifier<Object, ItemProcessor>() {

			@Override
			public ItemProcessor classify(Object classifiable) {
				if(classifiable instanceof Client) 
					return new ClientProcessor();
				else
					return new TransactionProcessor();
			}
			
		};
	}
}
