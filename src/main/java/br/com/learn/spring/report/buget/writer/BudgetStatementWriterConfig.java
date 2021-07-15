package br.com.learn.spring.report.buget.writer;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Payment;
import br.com.learn.spring.comum.model.PaymentGroup;

@Configuration
public class BudgetStatementWriterConfig {
	@Bean
	public ItemWriter<PaymentGroup> budgetStatementWriterr() {
		return itens -> {
			System.out.println("\n");
			System.out.println(String.format("SISTEMA INTEGRADO: XPTO \t\t\t\t DATA: %s", new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
			System.out.println(String.format("MÓDULO: ORÇAMENTO \t\t\t\t\t HORA: %s", new SimpleDateFormat("HH:MM").format(new Date())));
			System.out.println(String.format("\t\t\tDEMONSTRATIVO ORCAMENTARIO"));
			System.out.println(String.format("----------------------------------------------------------------------------"));
			System.out.println(String.format("CODIGO NOME VALOR"));
			System.out.println(String.format("\t Data Descricao Valor"));
			System.out.println(String.format("----------------------------------------------------------------------------"));
			
			Double totalAll = 0.0;
			for (PaymentGroup group : itens) {
				System.out.println(String.format("[%d] %s - %s", group.getCodNatureExpense(),
						group.getDescNatureExpense(),
						NumberFormat.getCurrencyInstance().format(group.getTotal())));
				totalAll += group.getTotal();
				for (Payment payment : group.getPaymentList()) {
					System.out.println(String.format("\t [%s] %s - %s", new SimpleDateFormat("dd/MM/yyyy").format(payment.getDate()), payment.getDescription(),
							NumberFormat.getCurrencyInstance().format(payment.getValue())));
				}
			}
			System.out.println("\n");
			System.out.println(String.format("\t\t\t\t\t\t\t  Total: %s", NumberFormat.getCurrencyInstance().format(totalAll)));
			System.out.println(String.format("\t\t\t\t\t\t\t  Código de Autenticação: %s", "fkyew6868fewjfhjjewf"));
		};
	}
}
