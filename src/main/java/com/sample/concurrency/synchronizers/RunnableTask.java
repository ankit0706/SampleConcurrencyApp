package com.sample.concurrency.synchronizers;

import java.util.concurrent.CountDownLatch;

public class RunnableTask implements Runnable{
	CountDownLatch start;
	CountDownLatch stop;
	
	public RunnableTask(CountDownLatch startLatch, CountDownLatch stopLatch) {
		this.start = startLatch;
		this.stop = stopLatch;
		
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("Inside run of " + name);
		try {
			start.await();
			for(int i = 0; i < 100; i++) {
				System.out.println(i);
			}
			System.out.println("Job finished for " + name);
			stop.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}


}
