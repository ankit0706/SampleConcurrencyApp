package com.sample.concurrency.threadpool;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

import javax.annotation.PreDestroy;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@Autowired
	private ExecutorService executor;
	
	/**
	 * Receives xml and writes them on to the disk
	 * using Thread Pool executor
	 * @param message
	 * @return
	 */
	@PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestBody String message) {
		executor.execute(new FileWriterTask(message));
		return "File written";
    }
		
	private class FileWriterTask implements Runnable{
		String data;
		
		FileWriterTask(String content){
			this.data = content;
		}

		@Override
		public void run() {
			try {
				String fileName = UUID.randomUUID().toString();
				File file = new File("C:/xmlFiles/" + fileName + ".xml");
				FileUtils.writeStringToFile(file, data, Charset.forName("UTF-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@PreDestroy
	private void destroy() {
		if(executor != null) {
			executor.shutdownNow();
			System.out.println("executor.isShutdown() = " + executor.isShutdown());
			System.out.println("executor.isTerminated() = " + executor.isTerminated());
		}
	}
}
