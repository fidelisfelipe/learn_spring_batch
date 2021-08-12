package br.com.learn.spring.jdbc.accountBank.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class AccountJobConfig {
	
	@Autowired
	private JobBuilderFactory builderFactory;
	
	@Bean
	public Job accountJob(Step accountStep) {
		return builderFactory
				.get("accountJob")
				.start(accountStep)
				//for non clean of metadata
				.incrementer(new RunIdIncrementer())
				.build();
	}

}
