package com.sample.concurrency.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.sample.concurrency.blockingqueue")
@EnableScheduling
public class CustomConfig {

	@Bean
	public ExecutorService getCustomThreadPool() {
		return Executors.newFixedThreadPool(4);
	}

	@Bean
	public ArrayBlockingQueue<String> getBlockingQueue() {
		return new ArrayBlockingQueue<String>(10);
	}

}
