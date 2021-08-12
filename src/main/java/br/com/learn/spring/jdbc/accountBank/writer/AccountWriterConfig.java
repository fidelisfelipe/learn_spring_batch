package br.com.learn.spring.jdbc.accountBank.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Account;

@Configuration
public class AccountWriterConfig {

	/**
	 * For writer in lote in transactional
	 * @param dataSource 
	 * @return
	 */
	@Bean
	public JdbcBatchItemWriter<Account> jdbcAccountWriter(@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Account>()
				.dataSource(dataSource)
				.sql("INSERT INTO account(tipo,limite,client_id)VALUES(?,?,?)")
				.itemPreparedStatementSetter(itemPreparedStatementSetter())
				.build();
	}

	private ItemPreparedStatementSetter<Account> itemPreparedStatementSetter() {
		return new ItemPreparedStatementSetter<Account>() {

			@Override
			public void setValues(Account item, PreparedStatement ps) throws SQLException {
				ps.setString(1, item.getType().name());
				ps.setDouble(2, item.getLimit());
				ps.setString(3, item.getClientId());
			}
			
		};
	}
	
}
