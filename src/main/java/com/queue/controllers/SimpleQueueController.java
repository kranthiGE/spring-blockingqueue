package com.queue.controllers;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.queue.services.SimpleQueueService;

@RestController
public class SimpleQueueController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SimpleQueueController.class);

	@Autowired
	SimpleQueueService simpleQueueService;
	
	@Autowired
	BlockingQueue<Integer> blockingQueue;
	
	@PostMapping("/testpost")
	public @ResponseBody ResponseEntity<String> post() {
		return new ResponseEntity<String>("POST Response", HttpStatus.OK);
	}
	
	//api to add to blocking queue and initialize a thread
	@PostMapping("/post")
	public @ResponseBody ResponseEntity<String> addToQueue(@RequestBody Integer productId) {
		try {
			blockingQueue.put(productId);
		} catch (InterruptedException e) {
			LOG.error("exception in adding" + e);
		}
		simpleQueueService.processQueue();
		return new ResponseEntity<String>("added", HttpStatus.OK);
	}
	
	@PostMapping("/postAll")
	public @ResponseBody ResponseEntity<String> addToQueue() {
		try {
			for(int i = 0; i < 10; i++) {
				blockingQueue.put(i);
			}
		} catch (InterruptedException e) {
			LOG.error("exception in adding" + e);
		}
		simpleQueueService.processQueue();
		return new ResponseEntity<String>("added", HttpStatus.OK);
	}
	
	
}
