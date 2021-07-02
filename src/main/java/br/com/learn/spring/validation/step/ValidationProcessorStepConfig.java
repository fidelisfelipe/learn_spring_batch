package br.com.learn.spring.validation.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class ValidationProcessorStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step validationProcessStep(
			ItemReader<Client> validationProcessReader,
			ItemProcessor<Client, Client> validationProcessProcessor,
			ItemWriter<Client> validationProcessWriter) {
		return stepBuilderFactory
				.get("validationProcessStep")
				.<Client, Client>chunk(1)
				.reader(validationProcessReader)
				.processor(validationProcessProcessor)
				.writer(validationProcessWriter)
				.build();
	}
}
