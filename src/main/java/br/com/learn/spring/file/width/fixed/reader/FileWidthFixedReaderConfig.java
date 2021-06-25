package br.com.learn.spring.file.width.fixed.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Cliente;

@Configuration
public class FileWidthFixedReaderConfig {
	
	@StepScope
	@Bean
	public FlatFileItemReader<Cliente> fileWidthFixedReader(@Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes) {
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("fileWidthFixedReader")
				.resource(arquivoClientes)
				.fixedLength()
				.columns(new Range[] {new Range(1,10), new Range(11,20), new Range(21,23), new Range(24,42)})
				.names(new String[] {"nome","sobrenome","idade","email"})
				.targetType(Cliente.class)
				.build();
	}

	
}
