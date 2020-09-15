package com.sample.concurrency.copyonwrite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * First we will populate an ArrayList.
 * Multiple Threads will read from it.
 * One thread will write to it while others 
 * are reading. Then we will try the same operation
 * with CopyOnArrayList
 * @author AANU
 *
 */
public class SampleCopyOnWriteArray {
	//public static ArrayList<String> sharedList;
	public static CopyOnWriteArrayList<String> sharedList;
	
	public static void main(String[] args) throws InterruptedException {
		createList();
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		//start read task 1
		//executor.scheduleAtFixedRate(new ReadTask1(), 0, 2, TimeUnit.SECONDS);
		//start read task 2
		//executor.scheduleAtFixedRate(new ReadTask2(dataSet), 0, 2, TimeUnit.SECONDS);
		//start modify task
		executor.schedule(new ModifyTask(), 5, TimeUnit.SECONDS);
		readData();
		readData();
	}
	
	private static void createList() {
		//sharedList = new ArrayList<>();
		sharedList = new CopyOnWriteArrayList<>();
		sharedList.add("Eins");
		sharedList.add("Zwei");
		sharedList.add("Drie");
		sharedList.add("Vier");
		sharedList.add("Funf");	
		sharedList.add("Scheeks");
		sharedList.add("Sieben");
		sharedList.add("Acht");
		sharedList.add("Neun");	
		sharedList.add("Zen");
		
		System.out.println(sharedList);
	}
	
	static void readData() throws InterruptedException {
		
		for(String str : sharedList) {
			System.out.println(str);
			Thread.sleep(1000);
		}

	}
	
	static void modifyData() {
		System.out.println("Data Modified");
		sharedList.add("Elf");
	}
}
