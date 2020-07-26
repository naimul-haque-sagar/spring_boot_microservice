package com.endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieEndpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieEndpointApplication.class, args);
	}

}
