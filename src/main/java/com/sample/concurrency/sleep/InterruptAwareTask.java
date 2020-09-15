package com.sample.concurrency.sleep;

public class InterruptAwareTask implements Runnable{

	@Override
	public void run() {
		int i = 0;
		while(!Thread.currentThread().isInterrupted())
			i++;
			//System.out.println(Thread.currentThread().isInterrupted());
			System.out.println("Displaying " + i);
		}
}
