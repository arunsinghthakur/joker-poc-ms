package com.joker.servicesecond.servicesecond;

import java.util.Random;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RefreshScope
@RestController
@RequestMapping("/api/servicesecond")
public class DemoResource {

	private final static Logger logger = LoggerFactory.getLogger(DemoResource.class);

	@Autowired
	private ConsumerChannel channel;

	@Value("${service2: Default Second Service}")
	private String message;

	@GetMapping("/dummy")
	@HystrixCommand(fallbackMethod = "fallBack", commandKey = "joker", groupKey = "joker-group")
	public String getDummyMsg() throws Exception {
		logger.info("Inside service second.......");
		if(RandomUtils.nextBoolean()) {
			throw new Exception();
		}
		return message + "." + channel.getMsg();
	}

	public String fallBack() {
		logger.info("This is fallback method.");
		return "This is dummy fallback message";
	}
}
