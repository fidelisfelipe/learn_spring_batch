package br.com.learn.spring.evenOdd.step.chunk;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EvenOddChunkStepConfig {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step evenOddStep() {
		return stepBuilderFactory
				.get("evenOddStep")
				.<Integer, String>chunk(1000)
				.reader(countForTenReader())
				.processor(evenOddProcessor())
				.writer(writer())
				.build();
	}

	private ItemWriter<? super String> writer() {
		return itens -> itens.forEach(System.out::println);
	}

	private FunctionItemProcessor<Integer,String> evenOddProcessor() {
		return new FunctionItemProcessor<>(item -> item % 2 == 0 ? String.format("Item %s é Par", item) : String.format("Item %s é Impar", item));
	}

	private IteratorItemReader<Integer> countForTenReader() {
		List<Integer> numOneForTen = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		return new IteratorItemReader<Integer>(numOneForTen.iterator());
	}
}
