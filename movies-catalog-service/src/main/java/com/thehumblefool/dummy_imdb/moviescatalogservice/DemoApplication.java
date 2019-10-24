package com.thehumblefool.dummy_imdb.moviescatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// @Bean
	// @LoadBalanced
	// public RestTemplate restTemplate()
	// {
	// return new RestTemplate();
	// }

	// @Bean
	// public MovieInfoErrorDecoder movieInfoErrorDecoder() {
	// 	return new MovieInfoErrorDecoder();
	// }
}
