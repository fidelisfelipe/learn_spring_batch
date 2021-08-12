package br.com.learn.spring.jdbc.accountBank.writer;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Account;

@Configuration
public class CompositeAccountWriterConfig {
	@Bean
	public CompositeItemWriter<Account> compositeAccountWriter(
			FlatFileItemWriter<Account> flatFileItemWriter,
			JdbcBatchItemWriter<Account> jdbcBatchItemWriter){
		return new CompositeItemWriterBuilder<Account>()
				.delegates(flatFileItemWriter, jdbcBatchItemWriter)
				.build();
	}
}
