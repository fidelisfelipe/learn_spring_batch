package br.com.learn.spring.file.width.fixed.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class FileWithFixedWriterConfig {
	@Bean
	public ItemWriter<br.com.learn.spring.comum.model.Client> fileWidthFixedWriter() {
		return items -> items.forEach(System.out::println);
//		return items -> {
//			for(Cliente cliente:items) {
//				if(cliente.getNome().equals("Maria"))
//					throw new Exception("Falha");
//				else
//					System.out.println(cliente);
//			}
//		};
	}
}
