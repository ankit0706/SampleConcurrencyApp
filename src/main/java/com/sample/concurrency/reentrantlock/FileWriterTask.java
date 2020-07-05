package com.sample.concurrency.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class FileWriterTask implements Runnable{
	ReentrantLock mLock = new ReentrantLock();
	
	@Override
	public void run() {
		printAlphabets();
		printNumerals();
	}
	
	public void printAlphabets() {
		mLock.lock();
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
		mLock.unlock();
	}
	
}


