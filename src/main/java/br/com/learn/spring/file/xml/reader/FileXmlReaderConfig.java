package br.com.learn.spring.file.xml.reader;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.thoughtworks.xstream.XStream;

import br.com.learn.spring.comum.model.Trade;

@Configuration
public class FileXmlReaderConfig {
	
	@StepScope
	@Bean
	public StaxEventItemReader<Trade> fileXmlReader(@Value("#{jobParameters['fileXml']}") Resource file) {
		return new StaxEventItemReaderBuilder<Trade>()
				.name("fileXmlReader")
				.resource(file)
				.addFragmentRootElements("trade")
				.unmarshaller(tradeMarshaller())
				.build();
	}
	
	@Bean
	public XStreamMarshaller tradeMarshaller() {
		Map<String, Class> aliases = new HashMap<>();

		aliases.put("trade", Trade.class);
		aliases.put("price", BigDecimal.class);
		aliases.put("isin", String.class);
		aliases.put("customer", String.class);
		aliases.put("quantity", Long.class);

		XStreamMarshaller marshaller = new XStreamMarshaller();
//		XStream xstream = marshaller.getXStream();
//		xstream.allowTypeHierarchy(Trade.class);
//		XStream.setupDefaultSecurity(xstream);

		marshaller.setAliases(aliases);

		return marshaller;
	}
	
}
