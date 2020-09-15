package com.sample.concurrency.joins;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JoinExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		Thread t1 = new Thread(new CountingTask());
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Future<String> ret = executor.submit(new LetterTask());
		t1.start();
		//If we execute the join call on t1, it won't let main thread print the 
		//result of future task, before t1 is complete. So the print statement
		//always appears at the end. If we don't join, t1 and executor run in parallel
		//Since executor starts earlier and it's work is also lesser, it finishes before t1
		//and since the main thread is not waiting for t1, the print statement is executed 
		//before t1 finishes
		t1.join();
		//the print statement waits because it has future's get method, which blocks until result 
		//is available
		System.out.println("Result = " + ret.get());
		//just shutdown
		executor.shutdown();
	}
}
