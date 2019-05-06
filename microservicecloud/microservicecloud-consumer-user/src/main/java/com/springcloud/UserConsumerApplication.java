package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.myrule.MyselfRule;

@SpringBootApplication
@EnableEurekaClient
//在启动微服务时,使用自定义的Ribbon规则
@RibbonClient(name="MISCROSERVICECLOUD-PROVIDER-USER",configuration=MyselfRule.class)
public class UserConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserConsumerApplication.class, args);
	}
}
