package br.com.learn.spring.validation.processor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.spring.comum.model.Client;

@Configuration
public class ValidationProcessorConfig {
	private Set<String> emails = new HashSet<>();
	
	
	@Bean
	public ItemProcessor<Client, Client> validationProcess() {
//simple validate for annotation JSR 349 
//		BeanValidatingItemProcessor<Client> processor = new BeanValidatingItemProcessor<>();
//		processor.setFilter(true);//inogred items not valid
		
//advanced valiation
		ValidatingItemProcessor<Client> processor = new ValidatingItemProcessor<Client>();
		processor.setValidator(validator());
		
		processor.setFilter(true);//ignore items not valid
		
		return processor;
	}

	private Validator<Client> validator() {
		return new Validator<Client>() {
			@Override
			public void validate(Client client) throws ValidationException {
				if(client.getEmail().contains(client.getEmail()))
					throw new ValidationException(String.format("The Client %s has already been processed", client.getEmail()));
				emails.add(client.getEmail());				
			}
		};
	}
}
