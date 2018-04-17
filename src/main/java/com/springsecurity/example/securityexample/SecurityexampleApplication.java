package com.springsecurity.example.securityexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurityexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityexampleApplication.class, args);
	}
}
