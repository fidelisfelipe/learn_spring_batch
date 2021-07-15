package br.com.learn.spring.file.delimited.comma.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class FileDelimitedCommaReaderConfig {
	
	@StepScope
	@Bean
	public FlatFileItemReader<Client> fileDelimitedCommaReader(@Value("#{jobParameters['fileDelimitedComma']}") Resource file) {
		return new FlatFileItemReaderBuilder<Client>()
				.name("fileDelimitedCommaReader")
				.resource(file)
				.delimited()
				.names(new String[] {"firstname","lastname","age","email"})
				.targetType(Client.class)
				.build();
	}
	
}
