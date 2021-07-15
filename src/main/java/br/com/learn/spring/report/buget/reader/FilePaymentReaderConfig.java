package br.com.learn.spring.report.buget.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindException;

import br.com.learn.spring.comum.model.Payment;
import br.com.learn.spring.comum.model.PaymentGroup;

@Configuration
public class FilePaymentReaderConfig {
	
	@Bean
	public FlatFileItemReader<PaymentGroup> filePaymentReader() {
		return new FlatFileItemReaderBuilder<PaymentGroup>()
				.name("filePaymentReader")
				.delimited()
				.names("codigoNaturezaDespesa", 
						"descricaoNaturezaDespesa", 
						"descricaoLancamento", 
						"dataLancamento", 
						"valorLancamento")
				.fieldSetMapper(paymentGroupFieldSetMapper())
				.build();
	}

	private FieldSetMapper<PaymentGroup> paymentGroupFieldSetMapper() {
		return new FieldSetMapper<PaymentGroup>() {

			@Override
			public PaymentGroup mapFieldSet(FieldSet fieldSet) throws BindException {
				PaymentGroup grupo = new PaymentGroup();
				grupo.setCodNatureExpense(fieldSet.readInt("codNatureExpense"));
				grupo.setDescNatureExpense(fieldSet.readString("descNatureExpense"));
				grupo.setPaymentTmp(new Payment());
				grupo.getPaymentTmp().setDate(fieldSet.readDate("date"));
				grupo.getPaymentTmp().setDescription(fieldSet.readString("description"));
				grupo.getPaymentTmp().setValue(fieldSet.readDouble("value"));
				return grupo;
			}
			
		};
	}
}
