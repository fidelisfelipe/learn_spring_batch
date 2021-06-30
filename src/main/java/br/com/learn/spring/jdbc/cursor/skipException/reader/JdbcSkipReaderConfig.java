package br.com.learn.spring.jdbc.cursor.skipException.reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransientException;
import java.util.zip.DataFormatException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import br.com.learn.spring.comum.model.Client;


@Configuration
public class JdbcSkipReaderConfig {

	@Bean
	public ItemReader<Client> jdbcSkipReader(@Qualifier("appDataSource")DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<Client>()
				.name("jdbcSkipReader")
				.dataSource(dataSource)
				.sql("select * from client")
				.rowMapper(rowMapper())
				.build();
	}

	private RowMapper<Client> rowMapper() {
		return new RowMapper<Client>() {

			@Override
			public Client mapRow(ResultSet rs, int rowNum) throws SQLException{
				SQLException sqlEx = new SQLException(String.format("Finally execution - Client not valid - %s", rs.getString("email")), "22");//add data exception SQLState
//				if(rs.getRow() >= 3 )
//					throw sqlEx;
//				else
					return clientRowMapper(rs);
			}

			private Client clientRowMapper(ResultSet rs) throws SQLException {
				Client cli = new Client();
				cli.setFirstName(rs.getString("firstname"));
				cli.setLastName(rs.getString("lastname"));
				cli.setAge(rs.getString("age"));
				cli.setEmail(rs.getString("email"));
				return cli;
			}
			
		};
	}

}
