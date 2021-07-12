package br.com.learn.spring.file.classifier.reader;

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
public class ClassifierClientTransactionLineMapperConfig {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public PatternMatchingCompositeLineMapper lineMapperClassifier() {
		// Esses transformam a linha em palavras
		Map<String, LineTokenizer> tokenizers = new HashMap<>();
		tokenizers.put("0*", clienteLineTokenizer());
		tokenizers.put("1*", transacaoLineTokenizer());
		// Esses mapeiam as palavras num objeto de domínio
		Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>(2);
		fieldSetMappers.put("0*", fieldSetMapper(Client.class));
		fieldSetMappers.put("1*", fieldSetMapper(Transaction.class));

		// Esse mapeador de linha do framework utiliza padrões para decidir qual lógica
		// de mapeamento será executada.
		PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
		lineMapper.setTokenizers(tokenizers);
		lineMapper.setFieldSetMappers(fieldSetMappers);
		return lineMapper;
	}

	private LineTokenizer clienteLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("firstname","lastname","age","email");
		lineTokenizer.setIncludedFields(1,2,3,4);
		return lineTokenizer;
	}

	private LineTokenizer transacaoLineTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id","description","value");
		lineTokenizer.setIncludedFields(1,2,3);
		return lineTokenizer;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private FieldSetMapper fieldSetMapper(Class classe) {
		BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(classe);
		return fieldSetMapper;
	}

}
