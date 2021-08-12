package br.com.learn.spring.jdbc.accountBank.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Account;
import br.com.learn.spring.comum.model.Client;

@Configuration
public class AccountStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step accountStep(
			ItemReader<? extends Client> accountReader,
			ItemProcessor<? super Client, ? extends Account> generatorAccountProcessor,
			ItemWriter<? super Account> jdbcAccountWriter) {
		return stepBuilderFactory
				.get("accountStep")
				.<Client, Account>chunk(100)
				.reader(accountReader)
				.processor(generatorAccountProcessor)
				.writer(jdbcAccountWriter)
				.build();
	}
	
}
