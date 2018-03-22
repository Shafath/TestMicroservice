package com.example.helloproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HelloProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloProducerApplication.class, args);
	}
}
