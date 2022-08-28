package com.kidylee.spring.security.addnewauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AddNewAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddNewAuthenticationApplication.class, args);
	}

}
