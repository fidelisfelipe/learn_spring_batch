package br.com.learn.spring.writer.file.witdth.fixed.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Client;

/**
 * O job vai ler clientes e imprimí-los no console (mostrar o job config).
 * 
 * Mostrar o formato do arquivo de clientes.
 * 
 * Rodar aplicação com: arquivoClientes=file:files/clientes.txt
 * 
 * Para mostrar o restart, comentar o incrementer e adicionar exceção no writer.
 */
@Configuration
public class WidthFixedReaderConfig {
	
	@StepScope
	@Bean
	public FlatFileItemReader<Client> writeFileWidthFixedReader(
	@Value("#{jobParameters['fileWidthFixed']}") Resource file) {
		return new FlatFileItemReaderBuilder<Client>()
                .name("writeFileWidthFixedReader")
                .resource(file)
                .fixedLength()
                .columns(new Range[]{new Range(1,10), new Range(11, 20), new Range(21, 23), new Range(24, 42)})
                .names(new String[] {"firstName", "lastName", "age", "email"})
                .targetType(Client.class)
                .build();
    }
}
