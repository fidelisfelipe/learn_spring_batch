package br.com.learn.spring.file.width.fixed.step.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Cliente;

@Configuration
public class FileWidthFixedStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step fileWidthFixedStep(ItemReader<Cliente> reader, ItemWriter<Cliente> writer) {
		return stepBuilderFactory
				.get("fileWidthFixedStep")
				.<Cliente, Cliente>chunk(1)
				.reader(reader)
				.writer(writer)
				.build();
	}


}
