package br.com.learn.spring.report.buget.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import br.com.learn.spring.comum.model.PaymentGroup;

@Component
public class PaymentGroupReader implements ItemStreamReader<PaymentGroup>, ResourceAwareItemReaderItemStream<PaymentGroup> {
	@Autowired
	// Reader file
	//private FlatFileItemReader<PaymentGroup> delegate;
	// Reader jdbc
	private JdbcCursorItemReader<PaymentGroup> delegate;
	private PaymentGroup paymentCurrent;

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		delegate.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		delegate.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		delegate.close();
	}

	@Override
	public void setResource(Resource resource) {
		// Descomentar para a leitura de arquivo
		//delegate.setResource(resource);
	}
	
	@Override
	public PaymentGroup read() throws Exception {
		if (paymentCurrent == null)
			paymentCurrent = delegate.read();
	
		PaymentGroup PaymentGroup = paymentCurrent;
		paymentCurrent = null;
		
		if (PaymentGroup != null) {
			PaymentGroup proxLancamento = peek();
			while (isLancamentoRelacionado(PaymentGroup, proxLancamento)) {
				PaymentGroup.getPaymentList().add(paymentCurrent.getPaymentTmp());
				proxLancamento = peek();
			}			
			PaymentGroup.getPaymentList().add(PaymentGroup.getPaymentTmp());
		}
		return PaymentGroup;
	}

	private boolean isLancamentoRelacionado(PaymentGroup PaymentGroup, PaymentGroup proxLancamento) {
		return proxLancamento != null && proxLancamento.getCodNatureExpense().equals(PaymentGroup.getCodNatureExpense());
	}
	
	public PaymentGroup peek() throws Exception {
		paymentCurrent = delegate.read();
		return paymentCurrent;
	}
}
