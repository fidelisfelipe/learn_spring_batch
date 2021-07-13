package br.com.learn.spring.file.width.fixed.step.chunk;

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
public class FileWidthFixedStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step fileWidthFixedStep(@Qualifier("fileWidthFixedReader")  ItemReader<Client> reader, @Qualifier("fileDelimitedWriter")ItemWriter<Client> writer) {
		return stepBuilderFactory
				.get("fileWidthFixedStep")
				.<Client, Client>chunk(4)
				.reader(reader)
				.writer(writer)
				.build();
	}


}
