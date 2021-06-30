package br.com.learn.spring.file.multFormat.reader.lineMapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;
import br.com.learn.spring.comum.model.Transaction;

@Configuration
public class ClientTransactionLineMapperConfig {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public PatternMatchingCompositeLineMapper lineMapper() {
		PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
		lineMapper.setTokenizers(tokenizers());
		lineMapper.setFieldSetMappers(fieldSetMappers());
		return lineMapper;
	}

	@SuppressWarnings("rawtypes")
	private Map<String, FieldSetMapper> fieldSetMappers() {
		Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();
		fieldSetMappers.put("0*", fieldSetMappers(Client.class));
		fieldSetMappers.put("1*", fieldSetMappers(Transaction.class));
		return fieldSetMappers;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private FieldSetMapper fieldSetMappers(Class targetType) {
		BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(targetType);
		return fieldSetMapper;
	}

	private Map<String, LineTokenizer>  tokenizers() {
		Map<String, LineTokenizer> tokenizers = new HashMap<>();
		tokenizers.put("0*", clientLineTokenizer());
		tokenizers.put("1*", transationLineTokenizer());
		return tokenizers;
	}

	private LineTokenizer clientLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("firstname","lastname","age","email");
		lineTokenizer.setIncludedFields(1,2,3,4);
		return lineTokenizer;
	}
	private LineTokenizer transationLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id","description","value");
		lineTokenizer.setIncludedFields(1,2,3);
		return lineTokenizer;
	}
	
}
