package com.sample.concurrency.synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SampleCountDownLatch {
	
	public static void main(String[] args) {
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch stopLatch = new CountDownLatch(4);
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		//launch all worker threads
		for(int i = 0; i < 4; i++) {
			executor.execute(new RunnableTask(startLatch, stopLatch));
		}
		startLatch.countDown();
		try {
			stopLatch.await();
			System.out.println("Stop Latch received");
			executor.shutdown();
			boolean isTerminated = executor.awaitTermination(10, TimeUnit.SECONDS);
			System.out.println("isTerminated = " +  isTerminated);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}	
}
