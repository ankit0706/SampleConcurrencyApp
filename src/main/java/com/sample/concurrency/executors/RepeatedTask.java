package com.sample.concurrency.executors;
/**
 * An Task that needs to be repeated at fixed interval
 * @author AANU
 *
 */
public class RepeatedTask implements Runnable{
	int count = 0;
	@Override
	public void run() {
		count++;
		System.out.println(count + ". Beep");
	}

}
