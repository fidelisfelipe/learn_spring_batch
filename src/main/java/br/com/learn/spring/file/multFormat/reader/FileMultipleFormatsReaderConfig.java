package br.com.learn.spring.file.multFormat.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class FileMultipleFormatsReaderConfig {
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@StepScope
	@Bean
	public FlatFileItemReader<Client> fileMultipleFormatsReader(@Value("#{jobParameters['fileMultipleFormats']}") Resource file, LineMapper lineMapper) {
		return new FlatFileItemReaderBuilder<Client>()
				.name("fileMultipleFormatsReader")
				.resource(file)
				.lineMapper(lineMapper)
				.build();
	}

	
}
