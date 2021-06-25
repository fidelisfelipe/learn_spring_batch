package br.com.learn.spring.step.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.model.Cliente;

@Configuration
public class ChunkReaderFileWidthFixedStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step readerFileWidthFixedStep(FlatFileItemReader<Cliente> reader, ItemWriter<Cliente> writer) {
		return stepBuilderFactory
				.get("readerFileWidthFixedStep")
				.<Cliente, Cliente>chunk(1)
				.reader(reader)
				.writer(writer)
				.build();
	}

}
