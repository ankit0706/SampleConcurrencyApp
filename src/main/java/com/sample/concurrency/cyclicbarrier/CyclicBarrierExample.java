package com.sample.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierExample {
	private static final int NUM_OF_PARTIES = 4;
	
	public static void main(String[] args) {
		CyclicBarrierExample example = new CyclicBarrierExample();
		example.testCyclicBarrier();
	}
	
	private void testCyclicBarrier() {
		AtomicInteger result = new AtomicInteger();
		result.set(0);
		CyclicBarrier barrier = new CyclicBarrier(NUM_OF_PARTIES, new FinalTask(result));
		Thread t1 = new Thread(new WorkerTask(barrier, result));
		t1.setName("T1");
		Thread t2 = new Thread(new WorkerTask(barrier, result));
		t2.setName("T2");
		Thread t3 = new Thread(new WorkerTask(barrier, result));
		t3.setName("T3");
		Thread t4 = new Thread(new WorkerTask(barrier, result));
		t4.setName("T4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
