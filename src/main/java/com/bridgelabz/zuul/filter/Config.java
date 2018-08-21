package com.bridgelabz.zuul.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chaitra Ankolekar
 * Purpose :Configuration class
 */
@Configuration
public class Config {
	
	@Bean
	public Prefilter prefilter() {
		return new Prefilter();
	}

	@Bean
	public Utility utility() {
		return new Utility();
	}
}
