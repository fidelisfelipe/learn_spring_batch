package br.com.learn.spring.report.buget.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import br.com.learn.spring.comum.model.Payment;
import br.com.learn.spring.comum.model.PaymentGroup;

@Configuration
public class DBPaymentReaderConfig {
	@Bean
	public JdbcCursorItemReader<PaymentGroup> dbPaymentReader(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<PaymentGroup>()
				.name("dbPaymentReader")
				.dataSource(dataSource)
				.sql("select * from app.payment")
				.rowMapper(rowMapper())
				.build();
	}

	private RowMapper<PaymentGroup> rowMapper() {
		return new RowMapper<PaymentGroup>() {

			@Override
			public PaymentGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
				PaymentGroup grupo = new PaymentGroup();
				grupo.setCodNatureExpense(rs.getInt("codNatureExpense"));
				grupo.setDescNatureExpense(rs.getString("descNatureExpense"));
				grupo.setPaymentTmp(new Payment());
				grupo.getPaymentTmp().setDate(rs.getDate("date"));
				grupo.getPaymentTmp().setDescription(rs.getString("description"));
				grupo.getPaymentTmp().setValue(rs.getDouble("value"));
				return grupo;
			}
		};
	}
}
