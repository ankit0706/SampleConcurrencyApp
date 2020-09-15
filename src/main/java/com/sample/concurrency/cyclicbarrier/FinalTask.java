package com.sample.concurrency.cyclicbarrier;

import java.util.concurrent.atomic.AtomicInteger;

public class FinalTask implements Runnable{
	private AtomicInteger finalResult;
	FinalTask(AtomicInteger total){
		this.finalResult = total;
	}
	
	@Override
	public void run() {
		System.out.println("All parties crossed barrier");
		System.out.println("Total is " + finalResult.get());
	}

}
