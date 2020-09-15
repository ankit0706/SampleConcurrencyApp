package com.sample.concurrency.atomic;

public class ReadTask implements Runnable{

	@Override
	public void run() {
		System.out.println("Value of i = " + AtomicExample.readValue());
	}

}
