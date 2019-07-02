package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.security.SpringApplicationContext;

@SpringBootApplication
public class photo_app_ws {

	public static void main(String[] args) {
		SpringApplication.run(photo_app_ws.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	/*
	@Bean
	public SpringApplicationContext springApplicationContext() {
		
		return new SpringApplicationContext();
	}*/
}
