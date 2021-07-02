package br.com.learn.spring.validation.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class ValidationProcessorReaderConfig {
	@StepScope
	@Bean
	public FlatFileItemReader<Client> validationProcessReader(
			@Value("#{jobParameters['fileDelimitedComma']}") Resource file) {
		return new FlatFileItemReaderBuilder<Client>()
				.name("validationProcessReader")
				.resource(file)
				.delimited()
				.names("firstName", "lastName", "age", "email")
				.targetType(Client.class)
				.build();
	}
}
