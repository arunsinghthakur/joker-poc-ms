package com.joker.servicesecond.servicesecond;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/servicesecond")
public class DemoResource {

	private final static Logger logger = LoggerFactory.getLogger(DemoResource.class);

	
	@Value("${service2: Default Second Service}")
	private String message;
	
	@GetMapping("/dummy")
	public String getDummyMsg() {
		logger.info("Inside service second.......");
		return message;
	}
}
