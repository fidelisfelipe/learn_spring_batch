package br.com.learn.spring.file.multipleFormats.step.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class FileListMultipleFormatsStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public Step fileListMultipleFormatsDelegateStep(@Qualifier("fileListMultipleFormatsReader") MultiResourceItemReader<Client> reader, @Qualifier("fileMultipleFormatsWriter")ItemWriter writer) {
		return stepBuilderFactory
				.get("fileListMultipleFormatsDelegateStep")
				.chunk(4)
				.reader(reader)
				.writer(writer)
				.build();
	}
	


}
