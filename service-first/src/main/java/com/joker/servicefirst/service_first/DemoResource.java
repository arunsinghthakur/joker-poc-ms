package com.joker.servicefirst.service_first;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api")
public class DemoResource {

	@Value("${service1: Default Hello}")
	private String message;
	
	@GetMapping("/dummy")
	public String getDummyMsg() {
		return message;
	}
}
