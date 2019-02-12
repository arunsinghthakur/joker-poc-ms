package com.joker.servicefirst.service_first;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
@RequestMapping("/api/servicefirst")
public class DemoResource {

	private final static Logger logger = LoggerFactory.getLogger(DemoResource.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${service1: Default Service First}")
	private String message;

	@GetMapping("/dummy")
	public String getDummyMsg() throws RestClientException, URISyntaxException {
		logger.info("Inside service first.......");
		logger.info("Calling service second.......");
		return "Message from first service :- " + message + ". Message from second service :- " + invokeSecondService();
	}

	private String invokeSecondService() throws RestClientException, URISyntaxException {
		return restTemplate.getForEntity(new URI("http://service-second/api/servicesecond/dummy"), String.class).getBody();

	}
}
