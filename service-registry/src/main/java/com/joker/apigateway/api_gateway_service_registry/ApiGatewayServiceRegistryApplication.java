package com.joker.apigateway.api_gateway_service_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApiGatewayServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceRegistryApplication.class, args);
	}

}
