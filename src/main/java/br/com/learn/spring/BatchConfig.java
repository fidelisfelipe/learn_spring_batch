package br.com.learn.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@EnableBatchProcessing
@Configuration
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job showJob() {
		return jobBuilderFactory
				.get("showJob")
				.start(showStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}

	private Step showStep() {
		return stepBuilderFactory
				.get("showStep")
				.tasklet(showTasklet(null))
				.build();
	}

	@Bean
	@StepScope
	public Tasklet showTasklet(@Value("#{jobParameters['name']}") String name) {
		return new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println(String.format("showStep %s!", name));
				return RepeatStatus.FINISHED;
			}
		};
	}
	
	
	
}
