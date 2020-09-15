package com.sample.concurrency.reenrantlock2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Here we use countdown latch as a simple notifier for
 * our executor service thread pool which tell us when all
 * the threads have finished execution. We provide the latch 
 * to all threads in thread pool and then calls await()
 * which blocks until it receives count from all threads.
 * As each thread finishes, it calls countdown() and 
 * when all threads in the thread pool have called countdown()
 * await() receives the required input and proceeds to shutdown
 * the pool.
 * @author AANU
 *
 */
public class LatchWithExecutor {
	
	private static final int NUM_THREADS = 4;
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
		CountDownLatch latch = new CountDownLatch(NUM_THREADS);
		int i=0;
		while(i < NUM_THREADS) {
			service.execute(new CountTask(latch));
			i++;
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//once the done signal is received
		service.shutdownNow();
		System.out.println("service.isShutdown() = " + service.isShutdown());
	}
	
	private static class CountTask implements Runnable{
		
		CountDownLatch latch;
		CountTask(CountDownLatch cdl){
			this.latch = cdl;
		}
		@Override
		public void run() {
			int i=0;
			while(i<10) {
				System.out.println(i);
				i++;
			}
			//send done signal
			latch.countDown();
		}
		
	}
}
