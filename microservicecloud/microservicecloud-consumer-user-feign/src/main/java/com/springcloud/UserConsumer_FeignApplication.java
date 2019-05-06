package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.springcloud"})
@ComponentScan("com.springcloud")
public class UserConsumer_FeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserConsumer_FeignApplication.class, args);
	}
}
