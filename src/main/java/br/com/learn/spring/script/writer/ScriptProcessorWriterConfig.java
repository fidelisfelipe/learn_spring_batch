package br.com.learn.spring.script.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class ScriptProcessorWriterConfig {
	@Bean
	public ItemWriter<Client> scriptProcessWriter() {
		return (clients) -> clients.forEach(System.out::println);
	}
}
