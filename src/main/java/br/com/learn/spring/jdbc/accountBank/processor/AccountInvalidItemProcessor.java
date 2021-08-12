package br.com.learn.spring.jdbc.accountBank.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.learn.spring.comum.model.Account;
import br.com.learn.spring.comum.model.Client;

public class AccountInvalidItemProcessor implements ItemProcessor<Client, Account>{

	@Override
	public Account process(Client item) throws Exception {
		Account account = new Account();
		account.setClientId(item.getEmail());
		return account;
	}

}
