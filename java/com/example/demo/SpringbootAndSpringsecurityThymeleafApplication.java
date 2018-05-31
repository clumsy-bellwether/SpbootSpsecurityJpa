package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class SpringbootAndSpringsecurityThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAndSpringsecurityThymeleafApplication.class, args);
	}
}
