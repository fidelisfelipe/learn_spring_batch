package br.com.learn.spring.script.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ScriptItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class ScriptProcessorConfig {
	
	//simple validate for annotation JSR 223 
	@Bean
	public ItemProcessor<Client, Client> scriptProcessProcessor() throws Exception {
		return new ScriptItemProcessorBuilder<Client, Client>()
				.language("nashorn")
				.scriptSource(
						"var email = item.getEmail();"+
						"var fileExist = `ls | grep ${email}.txt`;"+
						"if (fileExist) item; else; null")
						.build();
	}
	
}
