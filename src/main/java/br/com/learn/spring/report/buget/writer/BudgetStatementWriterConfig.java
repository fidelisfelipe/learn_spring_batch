package br.com.learn.spring.report.buget.writer;

import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.batch.item.file.ResourceSuffixCreator;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemWriterBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Payment;
import br.com.learn.spring.comum.model.PaymentGroup;

@Configuration
public class BudgetStatementWriterConfig {

	@StepScope
	@Bean
	public MultiResourceItemWriter<PaymentGroup> multiBudgetStatementWriter(
			@Value("#{jobParameters['budgetStatementList']}") Resource budgetStatementList,
			FlatFileItemWriter<PaymentGroup> budgetStatementWriter
			){
		return new MultiResourceItemWriterBuilder<PaymentGroup>()
				.name("multiBudgetStatementWriter")
				.resource(budgetStatementList)
				.delegate(budgetStatementWriter)
				.resourceSuffixCreator(suffixCreator())
				.itemCountLimitPerResource(1)//essa propriedade não garante X itens por recurso pois é dependente da configuração do chunk
				.build();
	}
	
	private ResourceSuffixCreator suffixCreator() {
		return new ResourceSuffixCreator() {
			@Override
			public String getSuffix(int index) {
				return index + ".txt";
			}
		};
	}
	
	@StepScope
	@Bean
	public FlatFileItemWriter<PaymentGroup> budgetStatementWriter(
			@Value("#{jobParameters['budgetStatement']}") Resource budgetStatement,
			BugetFooter footerCallback){
		return new FlatFileItemWriterBuilder<PaymentGroup>()
				.name("budgetStatementWriter")
				.resource(budgetStatement)
				.lineAggregator(lineAggregator())
				.headerCallback(headerCallback())
				.footerCallback(footerCallback)
				.build();
				
	}

	private FlatFileHeaderCallback headerCallback() {
	return new FlatFileHeaderCallback() {
		
		@Override
		public void writeHeader(Writer writer) throws IOException {
			writer.append(String.format("SISTEMA INTEGRADO: XPTO \t\t\t\t DATA: %s \n", new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
			writer.append(String.format("MÓDULO: ORÇAMENTO \t\t\t\t\t\t HORA: %s \n", new SimpleDateFormat("HH:MM").format(new Date())));
			writer.append(String.format("\t\t\tDEMONSTRATIVO ORCAMENTARIO\n"));
			writer.append(String.format("----------------------------------------------------------------------------\n"));
			writer.append(String.format("CODIGO NOME VALOR\n"));
			writer.append(String.format("\t Data Descricao Valor\n"));
			writer.append(String.format("----------------------------------------------------------------------------\n"));			
		}
	};
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
				return formatPaymentGroup + sb.toString();
				
			}
		};
	}
	
	
}
