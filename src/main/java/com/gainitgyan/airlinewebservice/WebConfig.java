package com.gainitgyan.airlinewebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gainitgyan.airlinewebservice.aop.LoggingInterceptor;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	
		registry.addInterceptor(new LoggingInterceptor());
	}
	
	@Bean
	public OpenAPI openApiConfig()
	{
		return new OpenAPI().info(new Info().title("Airline RESTFul Web Services")
				.version("1.0.0")
				.description("R for RESTFul Web Services")
				.termsOfService("http://gainITgyan.com/terms")
				.license(new License().name("GainITGyan License").url("http://gainITGyan.com")));
	}
	
}
