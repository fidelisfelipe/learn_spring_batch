package br.com.learn.spring.jdbc.paging.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class JdbcPagingJobConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job jdbcPagingJob(@Qualifier("jdbcPagingStep") Step step) {
		return jobBuilderFactory
				.get("jdbcPagingJob")
				.start(step)
				.incrementer(new RunIdIncrementer())
				.build();
	}

}
