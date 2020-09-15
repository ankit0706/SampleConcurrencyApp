package com.sample.concurrency.futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * Like a booking application, we will start a worker 
 * thread to do a task, but it will also be time bound.
 * This means if the task is not completed within given
 * time, the thread will be stopped
 * @author AANU
 *
 */
public class TimeBoundTaskExample {
	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Future<String> futureResult = service.submit(new TimeboundTask());
		//default way
		try {
			String result = futureResult.get(4500, TimeUnit.MILLISECONDS);
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			//If the thread was interrupted or execution failed
			//just log it and continue
			e.printStackTrace();
		} catch (TimeoutException e) {
			//If timeout exception comes, it means task was not completed
			//in due time. So stop the task
			e.printStackTrace();
			futureResult.cancel(true);
		}finally {
			service.shutdownNow();
		}
	}
}
