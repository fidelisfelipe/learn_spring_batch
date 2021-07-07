package br.com.learn.spring.file.json.step.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Trade;

@Configuration
public class FileJsonStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step fileJsonStep(@Qualifier("fileJsonReader") ItemReader<Trade> reader, @Qualifier("fileJsonWriter")ItemWriter<Trade> writer) {
		return stepBuilderFactory
				.get("fileJsonStep")
				.<Trade, Trade>chunk(4)
				.reader(reader)
				.writer(writer)
				.build();
	}
}
