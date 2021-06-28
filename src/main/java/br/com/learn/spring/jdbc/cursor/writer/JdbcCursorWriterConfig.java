package br.com.learn.spring.jdbc.cursor.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class JdbcCursorWriterConfig {
	@Bean
	public ItemWriter<Client> jdbcCursorWriter() {
		return items -> items.forEach(System.out::println);
	}
}
