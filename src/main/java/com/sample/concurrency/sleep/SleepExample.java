package com.sample.concurrency.sleep;

public class SleepExample {
	public static void main(String[] args) {
		RunningTask task = new RunningTask();
		Thread t = new Thread(task);
		t.start();
		
		//Sleep for a while
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		//interrupt the started task
		t.interrupt();
		
		//second example
//		Thread t2 = new Thread(new InterruptAwareTask());
//		t2.start();
//		//Sleep for a while
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			Thread.currentThread().interrupt();
//		}
//		//interrupt the started task
//		t2.interrupt();
		
	}
}
