package com.sample.concurrency.sleep;

import java.util.Date;

public class RunningTask implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			//wakeup time
			if(i == 51) {
				System.out.println("WakeupTime: " + new Date());
			}
			//Regular job
			System.out.println("Printing number " + i);
			//Sleep
			if(i == 50) {
				System.out.println("Sleeping for 10000 milliseconds");
				System.out.println("Sleeping Time: " + new Date());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					//if someone interrupts during sleep, interrupted exception will be thrown
					//but if someone is trying to interrupt, we should stop whatever we're doing
					//Here we simply break the loop. If we don't break the loop, interrupt will
					//simply wakeup the thread from sleep and it will continue its work.
					return;
				}
			}
		}
		
	}

}
