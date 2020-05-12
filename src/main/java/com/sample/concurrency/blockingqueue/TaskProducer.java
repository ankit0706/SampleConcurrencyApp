package com.sample.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TaskProducer {
	
	@Autowired
	ArrayBlockingQueue<String> queue;
	
	@PostMapping(value = "/putonqueue")
    public String putDataOnQueue(@RequestBody String message) {
		try {
			queue.put(message);
			System.out.println("message put on queue");
		} catch (InterruptedException e) {
			System.out.println("exception");
			e.printStackTrace();
		}
		return "File written";
    }
	
}
