package com.sample.concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * An example of how we can execute a task with delay
 * and execute a task repeatedly with fixed interval
 * using ScheduledThreadPoolExecutor
 * @author AANU
 *
 */
public class SampleScheduledExecutor {
	private static long initialDelay = 10;
	private static long interval = 10;
	
	public static void main(String[] args) {
		 ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(1);
		 //This will keep executing the task at fixed interval
		 ScheduledFuture<?> futureTask = scheduledService.scheduleAtFixedRate(new RepeatedTask(), initialDelay, interval, TimeUnit.SECONDS);
		 //A future task is returned which can be used to cancel the execution after sometime
		 //Here we will cancel our repeated task after 100 seconds
		 scheduledService.schedule(new TaskStopper(futureTask, scheduledService), 100, TimeUnit.SECONDS);		
			 
		 }
}
