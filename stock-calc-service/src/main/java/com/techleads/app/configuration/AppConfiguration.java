package com.techleads.app.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration

@EnableSwagger2
public class AppConfiguration {
	@Bean
	public HttpHeaders httpHeaders() {
		return new HttpHeaders();
	}
	 
	 @Bean
	 public Docket docket() {
		return  new Docket(DocumentationType.SWAGGER_2)
		 .select() //select all rest controllers
		 .apis(RequestHandlerSelectors.basePackage("com.techleads.app.controller")) //inside package
		 .paths(PathSelectors.regex("/stocks.*")) //starting path
		 .build()
		 .apiInfo(apiInfo());
		
	 }
	
	 private ApiInfo apiInfo() {
	     return new ApiInfo(
	       "Stocks-Calculate REST API", 
	       "Stocks-Price Rest API.", 
	       "API TOS", 
	       "Terms of service", 
	       new Contact("TechLeads", "techLeads.org", "techLeads@opensource"), 
	       "License of API", "API license URL", Collections.emptyList());
	 }

}
