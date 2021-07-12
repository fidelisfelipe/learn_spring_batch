package br.com.learn.spring.writer.file.witdth.fixed.writer;


import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class WidthFixedWriterConfig {

	@StepScope
	@Bean
	public FlatFileItemWriter<Client> writeFileWidthFixedWriter(
			@Value("#{jobParameters['fileOut']}") Resource fileOut) {
		return new FlatFileItemWriterBuilder<Client>()
				.name("writeFileWidthFixedWriter")
				.resource(fileOut)
				.formatted()
				.format("%-9s %-9s %-2s %-19s")
				.names("firstName","lastName","age","email")
				.build();
	}
}
