package br.com.learn.spring.jdbc.accountBank.processor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import br.com.learn.spring.comum.model.Account;
import br.com.learn.spring.comum.model.AccountType;
import br.com.learn.spring.comum.model.Client;

public class GeneratorAccountClassifier implements Classifier<Client, ItemProcessor<?, ? extends Account>>{

	/**
	 * UUID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ItemProcessor<Client, ? extends Account> classify(Client client) {
		return processorMap.get(AccountType.salaryRange(client.getSalaryRange()));
	}
	
	private static final Map<AccountType, ItemProcessor<Client, Account>> processorMap = 
			new HashMap<AccountType, ItemProcessor<Client, Account>>(){
				/**
				 * UUID
				 */
				private static final long serialVersionUID = 1L;

			{
				put(AccountType.SILVER, new AccountSilverItemProcessor());
				put(AccountType.GOLD, new AccountGoldItemProcessor());
				put(AccountType.PLATINUM, new AccountPlatinumItemProcessor());
				put(AccountType.DIAMOND, new AccountDiamondItemProcessor());
			}};
	
}
