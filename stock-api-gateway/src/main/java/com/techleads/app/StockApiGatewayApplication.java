package com.techleads.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@EnableZuulProxy
@SpringBootApplication
public class StockApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApiGatewayApplication.class, args);
	}
	

}
