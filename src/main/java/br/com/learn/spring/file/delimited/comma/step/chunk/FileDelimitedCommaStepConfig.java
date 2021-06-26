package br.com.learn.spring.file.delimited.comma.step.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class FileDelimitedCommaStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step fileDelimitedCommaStep(@Qualifier("fileDelimitedCommaReader") ItemReader<Client> reader, @Qualifier("fileDelimitedCommaWriter")ItemWriter<Client> writer) {
		return stepBuilderFactory
				.get("fileDelimitedCommaStep")
				.<Client, Client>chunk(4)
				.reader(reader)
				.writer(writer)
				.build();
	}


}
