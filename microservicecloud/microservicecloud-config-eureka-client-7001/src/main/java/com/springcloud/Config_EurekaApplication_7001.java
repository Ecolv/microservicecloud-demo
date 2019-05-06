package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Config_EurekaApplication_7001 {
	public static void main(String[] args) {
		SpringApplication.run(Config_EurekaApplication_7001.class, args);
	}
}
