package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//自动注册进eureka服务中
@EnableEurekaClient
//服务发现
@EnableDiscoveryClient
//开启Hystrix熔断机制的支持
@EnableCircuitBreaker
public class UserProvider_HystrixApplication_8001 {
	public static void main(String[] args) {
		SpringApplication.run(UserProvider_HystrixApplication_8001.class, args);
	}
}
