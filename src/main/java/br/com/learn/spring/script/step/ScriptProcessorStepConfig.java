package br.com.learn.spring.script.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class ScriptProcessorStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step scriptProcessStep(
			ItemReader<Client> scriptProcessReader,
			ItemProcessor<Client, Client> scriptProcessProcessor,
			ItemWriter<Client> scriptProcessWriter) {
		return stepBuilderFactory
				.get("scriptProcessStep")
				.<Client, Client>chunk(1)
				.reader(scriptProcessReader)
				.processor(scriptProcessProcessor)
				.writer(scriptProcessWriter)
				.build();
	}
}
