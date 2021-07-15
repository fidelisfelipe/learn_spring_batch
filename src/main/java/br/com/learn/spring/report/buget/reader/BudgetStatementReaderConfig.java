package br.com.learn.spring.report.buget.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.PaymentGroup;

@Configuration
public class BudgetStatementReaderConfig {
	@StepScope
	@Bean
	public MultiResourceItemReader<PaymentGroup> budgetStatementReader(
			@Value("#{jobParameters['filePaymentList']}") Resource[] filePaymentList,
			PaymentGroupReader paymentGroupReader) {
		return new MultiResourceItemReaderBuilder<PaymentGroup>()
				.name("budgetStatementReader")
				.resources(filePaymentList)
				.delegate(paymentGroupReader)
				.build();
	}
}
