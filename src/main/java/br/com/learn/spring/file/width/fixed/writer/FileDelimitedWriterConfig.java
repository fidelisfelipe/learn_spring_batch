package br.com.learn.spring.file.width.fixed.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class FileDelimitedWriterConfig {
	@StepScope
	@Bean
	public FlatFileItemWriter<Client> fileDelimitedWriter(@Value("#{jobParameters['fileOutTwo']}") Resource fileOut) {
		return new FlatFileItemWriterBuilder<Client>()
			   .name("fileDelimitedWriter")
			   .resource(fileOut)
			   .delimited()
			   .delimiter(";")
			   .names("firstName","lastName","age","email")
			   .build();
		
	}
}
