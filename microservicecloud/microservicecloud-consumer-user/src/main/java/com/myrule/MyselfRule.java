package com.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MyselfRule {
	@Bean
	public IRule myRule() {
		//Ribbon默认是轮询,改成随机
//		return new RandomRule();
		//自定义策略,服务每调用5次，再轮询
		return new MyRoundRobinRule();
	}
}
