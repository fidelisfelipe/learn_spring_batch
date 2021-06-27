package br.com.learn.spring.file.delimited.comma.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

import br.com.learn.spring.comum.model.Client;
import br.com.learn.spring.comum.model.Transaction;

public class FileTransactionClientReader implements ItemStreamReader<Client>{

	private Object objectCurrent;
	private ItemStreamReader<Object> delegate;
	
	
	public FileTransactionClientReader(ItemStreamReader<Object> delegate) {
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

}
