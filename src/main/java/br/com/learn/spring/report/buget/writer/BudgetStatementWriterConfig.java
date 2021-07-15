package br.com.learn.spring.report.buget.writer;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Payment;
import br.com.learn.spring.comum.model.PaymentGroup;

@Configuration
public class BudgetStatementWriterConfig {
//	@Bean
//	public ItemWriter<PaymentGroup> budgetStatementWriter() {
//		return itens -> {
//			System.out.println("\n");
//			System.out.println(String.format("SISTEMA INTEGRADO: XPTO \t\t\t\t DATA: %s", new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
//			System.out.println(String.format("MÓDULO: ORÇAMENTO \t\t\t\t\t HORA: %s", new SimpleDateFormat("HH:MM").format(new Date())));
//			System.out.println(String.format("\t\t\tDEMONSTRATIVO ORCAMENTARIO"));
//			System.out.println(String.format("----------------------------------------------------------------------------"));
//			System.out.println(String.format("CODIGO NOME VALOR"));
//			System.out.println(String.format("\t Data Descricao Valor"));
//			System.out.println(String.format("----------------------------------------------------------------------------"));
//			
//			Double totalAll = 0.0;
//			for (PaymentGroup group : itens) {
//				System.out.println(String.format("[%d] %s - %s", group.getCodNatureExpense(),
//						group.getDescNatureExpense(),
//						NumberFormat.getCurrencyInstance().format(group.getTotal())));
//				totalAll += group.getTotal();
//				for (Payment payment : group.getPaymentList()) {
//					System.out.println(String.format("\t [%s] %s - %s", new SimpleDateFormat("dd/MM/yyyy").format(payment.getDate()), payment.getDescription(),
//							NumberFormat.getCurrencyInstance().format(payment.getValue())));
//				}
//			}
//			System.out.println("\n");
//			System.out.println(String.format("\t\t\t\t\t\t\t  Total: %s", NumberFormat.getCurrencyInstance().format(totalAll)));
//			System.out.println(String.format("\t\t\t\t\t\t\t  Código de Autenticação: %s", "fkyew6868fewjfhjjewf"));
//		};
//	}
	@StepScope
	@Bean
	public FlatFileItemWriter<PaymentGroup> budgetStatementWriter(
			@Value("#{jobParameters['budgetStatement']}") Resource budgetStatement){
		return new FlatFileItemWriterBuilder<PaymentGroup>()
				.name("budgetStatementWriter")
				.resource(budgetStatement)
				.lineAggregator(lineAggregator())
				.build();
				
	}

	private LineAggregator<PaymentGroup> lineAggregator() {
		return new LineAggregator<PaymentGroup>() {
			
			@Override
			public String aggregate(PaymentGroup group) {
				String formatPaymentGroup = String.format("[%d] %s - %s\n", group.getCodNatureExpense(),
						group.getDescNatureExpense(),
						NumberFormat.getCurrencyInstance().format(group.getTotal()));
				StringBuilder sb = new StringBuilder();
				
				for (Payment payment : group.getPaymentList()) {
					sb.append(String.format("\t [%s] %s - %s\n", new SimpleDateFormat("dd/MM/yyyy").format(payment.getDate()), payment.getDescription(),
							NumberFormat.getCurrencyInstance().format(payment.getValue())));
				}
				sb.append(formatPaymentGroup);
				String formatPayment = sb.toString();
				return formatPaymentGroup + formatPayment;
				
			}
		};
	}
	
	
}
