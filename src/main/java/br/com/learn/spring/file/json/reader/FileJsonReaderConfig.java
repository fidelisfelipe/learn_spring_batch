package br.com.learn.spring.file.json.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Trade;

@Configuration
public class FileJsonReaderConfig {
	
	@StepScope
	@Bean
	public JsonItemReader<Trade> fileJsonReader(@Value("#{jobParameters['fileJson']}") Resource file) {
		return new JsonItemReaderBuilder<Trade>()
				 .jsonObjectReader(new JacksonJsonObjectReader<>(Trade.class))
                 .resource(file)
                 .name("fileJsonReader")
                 .build();
	}
	
}
