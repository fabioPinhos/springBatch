package com.udemy.primeiroprojetospringbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class ImprimeOlaSegundoTasklet implements Tasklet{
				
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//		System.out.println(String.format("Ola, %s!", nome));
		System.out.println("Olá, segundo mundo!");
		return RepeatStatus.FINISHED;
	}
		
}
