package br.com.learn.spring.file.xml.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Trade;

@Configuration
public class FileXmlWriterConfig {
	@Bean
	public ItemWriter<Trade> fileXmlWriter() {
		return items -> items.forEach(System.out::println);
	}
}
