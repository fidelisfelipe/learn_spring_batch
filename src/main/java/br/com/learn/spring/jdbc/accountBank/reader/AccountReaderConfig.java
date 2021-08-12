package br.com.learn.spring.jdbc.accountBank.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class AccountReaderConfig {
	@Bean
	public JdbcPagingItemReader<Client> accountReader(
			@Qualifier("appDataSource") DataSource dataSource,
			PagingQueryProvider queryProviderAccount
			){
		return new JdbcPagingItemReaderBuilder<Client>()
				.name("accountReader")
				.dataSource(dataSource)
				.queryProvider(queryProviderAccount)
				.rowMapper(new BeanPropertyRowMapper<Client>(Client.class))
				.build();
	}
	
	@Bean
	public SqlPagingQueryProviderFactoryBean queryProviderAccount(@Qualifier("appDataSource") DataSource dataSource) {
		SqlPagingQueryProviderFactoryBean queryProviderFactoryBean = new SqlPagingQueryProviderFactoryBean();
		queryProviderFactoryBean.setDataSource(dataSource);
		queryProviderFactoryBean.setSelectClause("select *");
		queryProviderFactoryBean.setFromClause("from client");
		queryProviderFactoryBean.setSortKey("email");
		return queryProviderFactoryBean;
	}
}
