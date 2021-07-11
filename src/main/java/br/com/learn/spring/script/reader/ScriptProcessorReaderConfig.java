package br.com.learn.spring.script.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class ScriptProcessorReaderConfig {
	@StepScope
	@Bean
	public FlatFileItemReader<Client> scriptProcessReader(
			@Value("#{jobParameters['fileDelimitedComma']}") Resource file) {
		return new FlatFileItemReaderBuilder<Client>()
				.name("scriptProcessReader")
				.resource(file)
				.delimited()
				.names("firstName", "lastName", "age", "email")
				.targetType(Client.class)
				.build();
	}
}
