package com.udemy.primeiroprojetospringbatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
		
	@Bean
	public Job imprimeOlaJob(Step imprimeOlaStep, Step imprimeOlaSegundoStep) {
		return jobBuilderFactory
				.get("imprimeOlaJob")
				.start(imprimeOlaStep)
				.next(imprimeOlaSegundoStep)
				.next(imprimeOlaSegundoStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
//	@Bean
//	public Job imprimeOlaSegundoJob(Step imprimeOlaSegundoStep) {
//		return jobBuilderFactory
//				.get("imprimeOlaSegundoJob")
//				.start(imprimeOlaSegundoStep)
//				.incrementer(new RunIdIncrementer())
//				.build();
//	}
	
}
