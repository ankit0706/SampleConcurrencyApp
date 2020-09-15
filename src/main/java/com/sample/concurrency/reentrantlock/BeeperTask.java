package com.sample.concurrency.reentrantlock;


public class BeeperTask implements Runnable{

	@Override
	public void run() {
		LockExample2.calculateAndPrint();
	}

}
