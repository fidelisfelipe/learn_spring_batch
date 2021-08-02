package br.com.learn.spring.report.buget.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.PaymentGroup;
import br.com.learn.spring.report.buget.reader.PaymentGroupReader;
import br.com.learn.spring.report.buget.writer.BugetFooter;

@Configuration
public class BudgetStatementStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step budgetStatementStep(
			// Esse aqui lê dos arquivos
			//MultiResourceItemReader<PaymentGroup> budgetStatementReader,
			// Esse aqui lê do banco de dados
			PaymentGroupReader budgetStatementReader,
			MultiResourceItemWriter<PaymentGroup> budgetStatementWriter,
			BugetFooter footerCallback) {
		return stepBuilderFactory
				.get("budgetStatementStep")
				.<PaymentGroup,PaymentGroup>chunk(1)
				.reader(budgetStatementReader)
				.writer(budgetStatementWriter)
				.listener(footerCallback)
				.build();
	}
}
