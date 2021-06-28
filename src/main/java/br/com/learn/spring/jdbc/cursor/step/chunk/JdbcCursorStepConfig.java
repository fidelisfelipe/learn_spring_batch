package br.com.learn.spring.jdbc.cursor.step.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class JdbcCursorStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step jdbcCursorStep(@Qualifier("jdbcCursorReader")  ItemReader<Client> reader, @Qualifier("jdbcCursorWriter")ItemWriter<Client> writer) {
		return stepBuilderFactory
				.get("jdbcCursorStep")
				.<Client, Client>chunk(4)
				.reader(reader)
				.writer(writer)
				.build();
	}


}
