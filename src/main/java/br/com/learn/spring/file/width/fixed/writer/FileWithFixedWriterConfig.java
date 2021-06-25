package br.com.learn.spring.file.width.fixed.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileWithFixedWriterConfig {
	@Bean
	public ItemWriter<br.com.learn.spring.comum.model.Cliente> fileFixedWriter() {
		return items -> items.forEach(System.out::println);
	}
}
