package br.com.learn.spring.file.width.fixed.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class FileWidthFixedReaderConfig {
	
	@StepScope
	@Bean
	public FlatFileItemReader<Client> fileWidthFixedReader(@Value("#{jobParameters['fileWidthFixed']}") Resource file) {
		return new FlatFileItemReaderBuilder<Client>()
				.name("fileWidthFixedReader")
				.resource(file)
				.fixedLength()
				.columns(new Range[] {new Range(1,10), new Range(11,20), new Range(21,23), new Range(24,42)})
				.names(new String[] {"firstname","lastname","age","email"})
				.targetType(Client.class)
				.build();
	}

	
}
