package br.com.learn.spring.jdbc.accountBank.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Account;

@Configuration
public class AccountWriterConfig {

	@Bean
	public ItemWriter<Account> accountWriter() {
		return items -> items.forEach(System.out::println);
	}
	
}
