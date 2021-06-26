package br.com.learn.spring.file.delimited.comma.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class FileDelimitedCommaWriterConfig {
	@Bean
	public ItemWriter<br.com.learn.spring.comum.model.Client> fileDelimitedCommaWriter() {
		return items -> items.forEach(System.out::println);
	}
}
