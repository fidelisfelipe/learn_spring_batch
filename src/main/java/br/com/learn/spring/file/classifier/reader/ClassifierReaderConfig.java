package br.com.learn.spring.file.classifier.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ClassifierReaderConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	@StepScope
	public FlatFileItemReader processadorClassifierReader(
			@Value("#{jobParameters['fileMultipleFormats']}") Resource files, 
			LineMapper lineMapperClassifier) {
		return new FlatFileItemReaderBuilder()
				.name("processadorClassifierReader")
				.resource(files)
				.lineMapper(lineMapperClassifier).build();

	}

}
