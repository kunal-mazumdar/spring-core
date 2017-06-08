package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.service.Calculator;

@Configuration
public class CalculatorConfig {

	@Bean
	@Scope("prototype")
	public Calculator calculator(){
		return new Calculator();
	}
}
