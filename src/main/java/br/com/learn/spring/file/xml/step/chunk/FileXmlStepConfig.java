package br.com.learn.spring.file.xml.step.chunk;

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
public class FileXmlStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step fileXmlStep(@Qualifier("fileXmlReader") ItemReader<Trade> reader, @Qualifier("fileXmlWriter")ItemWriter<Trade> writer) {
		return stepBuilderFactory
				.get("fileXmlStep")
				.<Trade, Trade>chunk(4)
				.reader(reader)
				.writer(writer)
				.build();
	}


}
