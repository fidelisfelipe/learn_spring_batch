package br.com.learn.spring.writer.file.witdth.fixed.job;

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
public class WidthFixedJobConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job writeFileWidthFixedJob(@Qualifier("writeFileWidthFixedStep") Step writeFileWidthFixedStep) {
		return jobBuilderFactory
				.get("writeFileWidthFixedJob")
				.start(writeFileWidthFixedStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
