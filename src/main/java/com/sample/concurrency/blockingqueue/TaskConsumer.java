package com.sample.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskConsumer {
	
	@Autowired
	ArrayBlockingQueue<String> queue;
	
	@Scheduled(initialDelay = 1000, fixedDelay = 5000)
	public void readFromQueue() {
		System.out.println("INSIDE readFromQueue");
		//try {
			String data = queue.poll();
			System.out.println(data);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}
