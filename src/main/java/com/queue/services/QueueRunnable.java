package com.queue.services;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class QueueRunnable implements Runnable {
	
	@Autowired
	BlockingQueue<Integer> blockingQueue;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public void run() {
		LOG.info("queue run invoked");
		
		try {
			while(true) {
				LOG.info("queue object hc: " + blockingQueue.hashCode());
				LOG.info("queue started for: " + Thread.currentThread().getName());
				
				Thread.sleep(15000);
				Integer number = blockingQueue.take();
				
				LOG.info("queue executed for: " + Thread.currentThread().getName() + " ,number: " + number );
			}
		} catch (InterruptedException e) {
			LOG.error("Exception in run: " + e);
			Thread.currentThread().interrupt();
		}
	}
}
