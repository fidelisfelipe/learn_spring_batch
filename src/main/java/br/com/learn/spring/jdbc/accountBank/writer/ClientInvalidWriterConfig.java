package br.com.learn.spring.jdbc.accountBank.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import br.com.learn.spring.comum.model.Account;

@Configuration
public class ClientInvalidWriterConfig {
	
	@Bean
	public FlatFileItemWriter<Account> clientInvalidWriter(){
		return new FlatFileItemWriterBuilder<Account>()
				.name("clientInvalidWriter")
				.resource(new FileSystemResource("./files/clientFails.txt"))
				.delimited()
				.names("clientId")
				.build();
	}

}
