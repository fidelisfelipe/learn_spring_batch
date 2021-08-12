package br.com.learn.spring.jdbc.accountBank.writer;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import br.com.learn.spring.comum.model.Account;

@Configuration
public class FileAccountWriterConfig {
	
	@Bean
	public FlatFileItemWriter<Account> fileAccountWriter(){
		return new FlatFileItemWriterBuilder<Account>()
				.name("fileAccountWriter")
				.resource(new FileSystemResource("./files/account.txt"))
				.delimited()
				.names("type", "limit", "clientId")
				.build();
	}

}
