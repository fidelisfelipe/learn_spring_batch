package br.com.learn.spring.report.buget.writer;

import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.List;

import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeWrite;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.stereotype.Component;

import br.com.learn.spring.comum.model.PaymentGroup;

@Component
public class BugetFooter implements FlatFileFooterCallback{

	private Double totalAll = 0.0;

	public void writeFooter(Writer writer) throws IOException{
		writer.append("\n");
		writer.append(String.format("\t\t\t\t\t\t\t  Total: %s \n", NumberFormat.getCurrencyInstance().format(totalAll)));
		writer.append(String.format("\t\t\t\t\t\t\t  Código de Autenticação: %s \n", "fkyew6868fewjfhjjewf"));
	}
	
	@BeforeWrite
	public void beforeWrite(List<PaymentGroup> paymentGroupList) {
		paymentGroupList.forEach((item) ->{
			totalAll+= item.getTotal();
		});
	}
	
	@AfterChunk
	public void afterChunk(ChunkContext context) {
		totalAll = 0.0;
	}
	
}
