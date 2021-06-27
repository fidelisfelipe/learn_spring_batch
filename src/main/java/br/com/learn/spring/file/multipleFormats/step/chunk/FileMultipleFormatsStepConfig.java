package br.com.learn.spring.file.multipleFormats.step.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;
import br.com.learn.spring.file.delimited.comma.reader.FileTransactionClientReader;

@Configuration
public class FileMultipleFormatsStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step fileMultipleFormatsStep(@Qualifier("fileMultipleFormatsReader") ItemReader<Client> reader, @Qualifier("fileMultipleFormatsWriter")ItemWriter<Client> writer) {
		return stepBuilderFactory
				.get("fileMultipleFormatsStep")
				.<Client, Client>chunk(4)
				.reader(reader)
				.writer(writer)
				.build();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public Step fileMultipleFormatsDelegateStep(@Qualifier("fileMultipleFormatsReader") FlatFileItemReader reader, @Qualifier("fileMultipleFormatsWriter")ItemWriter<Client> writer) {
		return stepBuilderFactory
				.get("fileMultipleFormatsDelegateStep")
				.<Client, Client>chunk(4)
				.reader(new FileTransactionClientReader(reader))
				.writer(writer)
				.build();
	}


}
