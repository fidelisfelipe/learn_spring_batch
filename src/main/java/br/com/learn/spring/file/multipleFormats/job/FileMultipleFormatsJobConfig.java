package br.com.learn.spring.file.multipleFormats.job;

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
public class FileMultipleFormatsJobConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job fileMultipleFormatsJob(@Qualifier("fileMultipleFormatsStep") Step step) {
		return jobBuilderFactory
				.get("fileMultipleFormatsJob")
				.start(step)
				.incrementer(new RunIdIncrementer())
				.build();
	}

}
