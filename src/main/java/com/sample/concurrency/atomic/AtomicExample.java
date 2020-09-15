package com.sample.concurrency.atomic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
	public static AtomicInteger i = new AtomicInteger(0);
	public static void main(String[] args) {
		ScheduledExecutorService executor1 = Executors.newSingleThreadScheduledExecutor();
		executor1.scheduleAtFixedRate(new ReadTask(), 0, 1, TimeUnit.SECONDS);
		
		executor1.scheduleAtFixedRate(new WriteTask(), 0, 1, TimeUnit.SECONDS);
	}
	
	public static int readValue() {
		return i.get();
	}
	
	public static void increment() {
		i.incrementAndGet();
	}
	
	public void decrement() {
		i.decrementAndGet();
	}
	
	
}
