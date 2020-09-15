package com.sample.concurrency.executors;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Give any future task instance to this task and it will
 * cancel it
 * @author AANU
 *
 */
public class TaskStopper implements Runnable{
	
	ScheduledFuture<?> mFutureTask;
	ScheduledExecutorService mExecutorService;
	
	public TaskStopper( ScheduledFuture<?> futureTask, ScheduledExecutorService executorService) {
		this.mFutureTask = futureTask;
		this.mExecutorService = executorService;
	}
	
	@Override
	public void run() {
		mFutureTask.cancel(true);
		System.out.println("Task stopped");
		mExecutorService.shutdownNow();
		boolean shutDown = mExecutorService.isShutdown();
		if(shutDown) {
			System.out.println("Executor shutdown");
		}else {
			System.out.println("Executor not shutdown");
		}
	}

}
