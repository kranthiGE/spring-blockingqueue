package com.queue.configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(QueueConfig.class);

	@Bean
	public BlockingQueue<Integer> blockingQueue(){
		LOG.info("initializing blocking queue instance");
		return new LinkedBlockingDeque<>(10);
	}
}
