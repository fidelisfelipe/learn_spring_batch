package br.com.learn.spring.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.chunk.ChunkPar;

@EnableBatchProcessing
@Configuration
public class ParJobConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private ChunkPar chunk;
	
	@Bean
	public Job showParJob() {
		return jobBuilderFactory
				.get("showParJob")
				.start(chunk.showParStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}

}
