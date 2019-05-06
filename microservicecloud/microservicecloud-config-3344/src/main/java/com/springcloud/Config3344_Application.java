package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config3344_Application {
	public static void main(String[] args) {
		SpringApplication.run(Config3344_Application.class, args);
	}
}
