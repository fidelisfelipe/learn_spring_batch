package br.com.learn.spring.file.classifier.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.learn.spring.comum.model.Client;

public class ClientProcessor implements ItemProcessor<Client, Client> {

	@Override
	public Client process(Client item) throws Exception {
		System.out.println(String.format("apply ClientProcessor in client %s", item.getEmail()));
		return item;
	}

}
