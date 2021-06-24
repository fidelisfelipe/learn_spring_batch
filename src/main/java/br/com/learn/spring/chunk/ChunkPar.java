package br.com.learn.spring.chunk;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChunkPar {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	public Step showParStep() {
		return stepBuilderFactory
				.get("showParStep")
				.<Integer, String>chunk(1000)
				.reader(countForTenReader())
				.processor(parOrImparProcessor())
				.writer(showWriter())
				.build();
	}

	private ItemWriter<? super String> showWriter() {
		return itens -> itens.forEach(System.out::println);
	}

	private FunctionItemProcessor<Integer,String> parOrImparProcessor() {
		return new FunctionItemProcessor<>(item -> item % 2 == 0 ? String.format("Item %s é Par", item) : String.format("Item %s é Impar", item));
	}

	private IteratorItemReader<Integer> countForTenReader() {
		List<Integer> numOneForTen = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		return new IteratorItemReader<Integer>(numOneForTen.iterator());
	}
}
