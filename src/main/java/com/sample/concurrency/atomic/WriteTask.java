package com.sample.concurrency.atomic;

public class WriteTask implements Runnable{

	@Override
	public void run() {
		AtomicExample.increment();
	}
}
