package br.com.learn.spring.file.delimited.comma.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class FileDelimitedCommaWriterConfig {
	@StepScope
	@Bean
	public FlatFileItemWriter<Client> fileDelimitedCommaWriter(@Value("#{jobParameters['fileDelimitedCommaOut']}") Resource file) {
		return new FlatFileItemWriterBuilder<Client>()
				.name("fileDelimitedCommaWriter")
				.resource(file)
				.delimited()
				.delimiter(",")
				.names("firstName","lastName","age","email")
				.build();
	}
}
