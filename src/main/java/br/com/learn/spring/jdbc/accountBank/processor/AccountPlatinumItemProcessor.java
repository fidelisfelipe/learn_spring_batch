package br.com.learn.spring.jdbc.accountBank.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.learn.spring.comum.model.Account;
import br.com.learn.spring.comum.model.AccountType;
import br.com.learn.spring.comum.model.Client;

class AccountPlatinumItemProcessor implements ItemProcessor<Client, Account>{

	@Override
	public Account process(Client item) throws Exception {
		Account account = new Account();
		account.setClientId(item.getEmail());
		account.setType(AccountType.PLATINUM);
		account.setLimit(2500.00);
		return account;
	}
}
