package com.sample.concurrency.joins;
/**
 * Square of numbers
 * @author AANU
 *
 */
public class CountingTask implements Runnable{

	@Override
	public void run() {
		int i=1;
		while(i < 101) {
			System.out.println("" + (i * i));
			i++;
		}
	}

}
