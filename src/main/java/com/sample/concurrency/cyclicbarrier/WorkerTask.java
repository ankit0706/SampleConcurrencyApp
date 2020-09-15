package com.sample.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkerTask implements Runnable{
	private CyclicBarrier barrier;
	private AtomicInteger aggregate;
	
	WorkerTask(CyclicBarrier cb, AtomicInteger result){
		this.barrier = cb;
		this.aggregate = result;
	}
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		int i=0;
		while(i<100) {
			System.out.println(i + ". " + threadName);
			i++;
			aggregate.incrementAndGet();
		}
		try {
			barrier.await();
			System.out.println(threadName + " proceeding.");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
