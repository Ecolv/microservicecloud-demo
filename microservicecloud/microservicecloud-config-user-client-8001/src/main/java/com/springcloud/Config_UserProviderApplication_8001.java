package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//自动注册进eureka服务中
@EnableEurekaClient
//服务发现
@EnableDiscoveryClient
public class Config_UserProviderApplication_8001 {
	public static void main(String[] args) {
		SpringApplication.run(Config_UserProviderApplication_8001.class, args);
	}
}
