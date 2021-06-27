package br.com.learn.spring.file.multFormat.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.file.delimited.comma.reader.FileTransactionClientReader;

@Configuration
public class FileListMultipleFormatsReaderConfig {
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@StepScope
	@Bean
	public MultiResourceItemReader fileListMultipleFormatsReader(
			@Value("#{jobParameters['fileListMultipleFormats']}") Resource[] fileList, @Qualifier("fileMultipleFormatsReader") FlatFileItemReader reader) {
		return new MultiResourceItemReaderBuilder()
				.name("fileListMultipleFormatsReader")
				.resources(fileList)
				.delegate(new FileTransactionClientReader(reader))
				.build();
	}

	
}
