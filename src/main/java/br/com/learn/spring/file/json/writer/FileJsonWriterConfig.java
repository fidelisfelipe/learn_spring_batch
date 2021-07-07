package br.com.learn.spring.file.json.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Trade;

@Configuration
public class FileJsonWriterConfig {
	//TODO: Learn Lambda 
	/**
	 * use SAM type
	 * @link {http://cr.openjdk.java.net/~briangoetz/lambda/lambda-state-final.html}
	 * @return
	 */
	@Bean
	public ItemWriter<Trade> fileJsonWriter() {
		return items -> items.forEach(System.out::println);
	}
}
