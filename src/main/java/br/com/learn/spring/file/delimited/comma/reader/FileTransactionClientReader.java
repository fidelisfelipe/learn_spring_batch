package br.com.learn.spring.file.delimited.comma.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

import br.com.learn.spring.comum.model.Client;
import br.com.learn.spring.comum.model.Transaction;

public class FileTransactionClientReader implements ItemStreamReader<Client>, ResourceAwareItemReaderItemStream<Client>{

	private Object objectCurrent;
	private FlatFileItemReader<Object> delegate;
	
	public FileTransactionClientReader(FlatFileItemReader<Object> delegate) {
		this.delegate = delegate;
	}
	
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
	public Client read() throws Exception{
		if(objectCurrent == null)
			objectCurrent = delegate.read();
			
		Client client = (Client) objectCurrent;
		objectCurrent = null;
		
		if(client != null) {
			while (peek() instanceof Transaction) 
				client.getTransactionList().add((Transaction)objectCurrent);
				
			
		}
		
		return client;
	}

	private Object peek() throws Exception {
		objectCurrent = delegate.read();
		return objectCurrent;
	}

	@Override
	public void setResource(Resource resource) {
		delegate.setResource(resource);		
	}

}
