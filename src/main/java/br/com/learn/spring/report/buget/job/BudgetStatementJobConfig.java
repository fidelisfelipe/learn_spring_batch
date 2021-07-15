package br.com.learn.spring.report.buget.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BudgetStatementJobConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job budgetStatementJob(Step budgetStatementStep) {
		return jobBuilderFactory
				.get("budgetStatementJob")
				.start(budgetStatementStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
