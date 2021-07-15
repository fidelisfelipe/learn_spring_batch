package br.com.learn.spring.file.multipleFormats.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileMultipleFormatsWriterConfig {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public ItemWriter fileMultipleFormatsWriter() {
		return items -> items.forEach(System.out::println);
	}
}
