package br.com.learn.spring.jdbc.cursor.skipException.step.chunk;

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
public class JdbcSkipStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step jdbcSkipStep(@Qualifier("jdbcSkipReader")  ItemReader<Client> reader, @Qualifier("jdbcSkipWriter")ItemWriter<Client> writer) {
		return stepBuilderFactory
				.get("jdbcSkipStep")
				.<Client, Client>chunk(4)
				.reader(reader)
				.writer(writer)
				.faultTolerant()
				.skip(Exception.class)
				.skipLimit(2)
				.build();
	}


}
