package br.com.learn.spring.writer.file.witdth.fixed.step;

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
public class WidthFixedStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step writeFileWidthFixedStep(@Qualifier("writeFileWidthFixedReader") ItemReader<Client> writeFileWidthFixedReader,
			@Qualifier("writeFileWidthFixedWriter")ItemWriter<Client> writeFileWidthFixedWriter) {
		return stepBuilderFactory
				.get("writeFileWidthFixedStep")
				.<Client, Client>chunk(1)
				.reader(writeFileWidthFixedReader)
				.writer(writeFileWidthFixedWriter)
				.build();
	}
}
