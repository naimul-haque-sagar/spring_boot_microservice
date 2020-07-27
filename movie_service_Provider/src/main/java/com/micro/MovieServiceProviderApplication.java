package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceProviderApplication.class, args);
	}

}
