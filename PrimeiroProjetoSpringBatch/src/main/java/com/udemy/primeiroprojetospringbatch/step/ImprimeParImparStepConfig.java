package com.udemy.primeiroprojetospringbatch.step;

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
public class ImprimeParImparStepConfig {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step imprimeParImparStep1() {
		return stepBuilderFactory
				.get("imprimeParImparStep1")
				.<Integer, String>chunk(5)
				.reader(contaAteDezReader())
				.processor(parOuImparProcessor())
				.writer(imprimeWriter())
				.build();
	}

	private ItemWriter<String> imprimeWriter() {
		return itens -> itens.forEach(System.out::println);
	}

	private FunctionItemProcessor<Integer, String> parOuImparProcessor() {
		return new FunctionItemProcessor<Integer, String>
		(item -> item % 2 == 0 ? String.format("Item %s é Par", item) : String.format("Item %s é Impar", item));
	}

	private IteratorItemReader<Integer> contaAteDezReader() {
		List<Integer> numeroDeUmAteDez = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		return new IteratorItemReader<Integer>(numeroDeUmAteDez);
	}

}
