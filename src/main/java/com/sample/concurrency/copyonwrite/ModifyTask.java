package com.sample.concurrency.copyonwrite;

public class ModifyTask implements Runnable{

	@Override
	public void run() {
		SampleCopyOnWriteArray.modifyData();
	}

	
}
