package br.com.learn.spring.jdbc.paging.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class JdbcPagingWriterConfig {
	@Bean
	public ItemWriter<Client> jdbcPagingWriter() {
		return items -> items.forEach(System.out::println);
	}
}
