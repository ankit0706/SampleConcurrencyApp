package com.sample.concurrency.shutdownhook;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.sample.concurrency.executors.RepeatedTask;

public class ShutdownHookExample {
	
	static ScheduledExecutorService service;
	
	public static void main(String[] args) {
		//It's job is to print beeps
		//service = Executors.newScheduledThreadPool(1);
		//ScheduledFuture<?> futureTask = service.scheduleAtFixedRate(new RepeatedTask(), 1, 1000, TimeUnit.SECONDS);
		
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
					System.out.println("Release resources");
			}
			
		}));
		int i = 0;
		while(i < 1000000000) {
			System.out.println(new Date());
			i++;
		}
		
	}
}
