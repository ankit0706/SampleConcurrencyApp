package com.sample.concurrency.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;
/**
 * I created this class to test Reentrant Lock.
 * Here I have 2 methods inside my runnable task,
 * The lock object is provided in the constructor of Runnable.
 * Lock is taken at start of method 1 and released at end of
 * method 2. So whichever thread starts first will finish its
 * both methods and then only 2nd thread will be able to execute.
 * Without this locking, when I started 2 threads consecutively,
 * the execution was random, but with the lock it was ordered.
 * @author AANU
 *
 */
public class SampleLockExample {
	private ReentrantLock mLock = new ReentrantLock();
	
	
	public static void main(String[] args){	
		SampleLockExample sampleLockExample = new SampleLockExample();
		sampleLockExample.testLocks();
	}
	
	private void testLocks() {
		Thread t1 = new Thread(new FileWriterTask(mLock));
		Thread t2 = new Thread(new FileWriterTask(mLock));
		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();
	}
	
	private static class FileWriterTask implements Runnable{
		ReentrantLock rLock;
		
		FileWriterTask(ReentrantLock l){
			this.rLock = l;
		}
		
		@Override
		public void run() {
			printAlphabets();
			printNumerals();
		}
		
		public void printAlphabets() {
			rLock.lock();
			System.out.println("INSIDE " + Thread.currentThread().getName());
			System.out.println("a");
			System.out.println("b");
			System.out.println("c");
			System.out.println("d");
			System.out.println("e");
			System.out.println("f");
			System.out.println("g");
			System.out.println("h");
			System.out.println("i");
			System.out.println("j");
			System.out.println("EXITING " + Thread.currentThread().getName());
		}
		
		public void printNumerals() {
			System.out.println("INSIDE " + Thread.currentThread().getName());
			System.out.println("0");
			System.out.println("1");
			System.out.println("2");
			System.out.println("3");
			System.out.println("4");
			System.out.println("5");
			System.out.println("6");
			System.out.println("7");
			System.out.println("8");
			System.out.println("9");
			System.out.println("EXITING " + Thread.currentThread().getName());
			rLock.unlock();
		}
	}
}
