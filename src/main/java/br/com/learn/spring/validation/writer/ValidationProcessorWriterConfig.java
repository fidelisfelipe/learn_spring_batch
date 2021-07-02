package br.com.learn.spring.validation.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class ValidationProcessorWriterConfig {
	@Bean
	public ItemWriter<Client> validationProcessWriter() {
		return clients -> clients.forEach(System.out::println);
	}
}
