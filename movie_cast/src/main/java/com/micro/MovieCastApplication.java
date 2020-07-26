package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieCastApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCastApplication.class, args);
	}

}
