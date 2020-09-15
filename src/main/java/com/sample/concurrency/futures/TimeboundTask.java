package com.sample.concurrency.futures;

import java.util.concurrent.Callable;

/**
 * This task must be completed within given time or 
 * else it will be stopped
 * @author AANU
 *
 */
public class TimeboundTask implements Callable<String>{

	@Override
	public String call() {
		int i = 0;
		//The thread may be interrupted so it is necessary to 
		//write the logic for action to be taken when thread is 
		//interrupted. If interruption is not handled. Execution
		//will go on as usual
		while(i < 9999999 && !Thread.currentThread().isInterrupted()) {
			i++;
			System.out.println(i * i);	
		}
		return String.valueOf(i);
	}

}
