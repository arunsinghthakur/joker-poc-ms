package com.joker.servicethird.servicethird;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServiceThirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceThirdApplication.class, args);
	}

}

