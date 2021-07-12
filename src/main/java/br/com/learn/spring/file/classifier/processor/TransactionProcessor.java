package br.com.learn.spring.file.classifier.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.learn.spring.comum.model.Transaction;

public class TransactionProcessor implements ItemProcessor<Transaction, Transaction>{

	@Override
	public Transaction process(Transaction item) throws Exception {
		System.out.println(String.format("apply TransactionProcessor in transaction %s", item.getId()));
		return item;
	}

}
