package com.queue.configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class SimpleThreadConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(SimpleThreadConfig.class);

	@Bean
	public ExecutorService threadPoolTaskExecutor() {
		LOG.info("initialized thread pool executor");
		return new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	}
}
