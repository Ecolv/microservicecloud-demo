package com.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springcloud.entity.User;

import feign.hystrix.FallbackFactory;

//必加
@Component
//交给UserClientServiceFallbackFactory统一处理
public class UserClientServiceFallbackFactory implements FallbackFactory<UserClientService>{
	@Override
	public UserClientService create(Throwable arg0) {
		return new UserClientService() {
			@Override
			public List<User> list() {
				return null;
			}
			
			@Override
			public User getOne(Long id) {
				User user = new User();
				user.setId(id);
				user.setUname("没有对应的信息,Consumer客户端提供的降级服务,此刻服务Provider已经关闭");
				return user;
			}
		};
	}
}
