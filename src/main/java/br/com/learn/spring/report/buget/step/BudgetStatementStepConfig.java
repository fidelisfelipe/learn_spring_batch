package br.com.learn.spring.report.buget.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.PaymentGroup;
import br.com.learn.spring.report.buget.reader.PaymentGroupReader;

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
			ItemWriter<PaymentGroup> budgetStatementWriter) {
		return stepBuilderFactory
				.get("budgetStatementStep")
				.<PaymentGroup,PaymentGroup>chunk(100)
				.reader(budgetStatementReader)
				.writer(budgetStatementWriter)
				.build();
	}
}
