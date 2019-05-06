package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_Gateway_9527Application {
	public static void main(String[] args) {
		SpringApplication.run(Zuul_Gateway_9527Application.class, args);
	}
}
