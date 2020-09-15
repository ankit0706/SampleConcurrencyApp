package com.sample.concurrency.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Here we will use the locking with try finally block
 * We also use the tryLock method with timeout
 * @author AANU
 *
 */
public class LockExample2 {
	private static ReentrantLock mLock = new ReentrantLock();
	
	public static void main(String[] args){	
		Thread t1 = new Thread(new BeeperTask());
		Thread t2 = new Thread(new BeeperTask());
		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();
	}
	
	//The task which requires lock
	public static boolean calculateAndPrint() {
		boolean isLockObtained = false;
		try {
			isLockObtained = mLock.tryLock(5, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Thread was interrupted while waiting to obtain lock");
		}
		//If lock is not obtained after waiting
		if(!isLockObtained) {
			return false;
		}
		try {
			//task
			int i = 0;
			while(i < 19) {
				int cube = i * i * i;
				System.out.println(Thread.currentThread().getName() + " " + cube);
				i++;
			}
			//lock was obtained and task completed
			return true;
		}finally {
			mLock.unlock();
		}
		
	}
}
