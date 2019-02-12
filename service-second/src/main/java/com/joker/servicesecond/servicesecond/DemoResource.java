package com.joker.servicesecond.servicesecond;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/servicesecond")
public class DemoResource {

	@Value("${service2: Default Second Service}")
	private String message;
	
	@GetMapping("/dummy")
	public String getDummyMsg() {
		return message;
	}
}
