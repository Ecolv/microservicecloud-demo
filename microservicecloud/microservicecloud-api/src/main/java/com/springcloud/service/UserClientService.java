package com.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcloud.entity.User;

@FeignClient(value="MISCROSERVICECLOUD-PROVIDER-USER",fallbackFactory=UserClientServiceFallbackFactory.class)
public interface UserClientService {
	@RequestMapping(value="/user/list",method=RequestMethod.GET)
	public List<User> list();
	@RequestMapping(value="/user/get/{id}",method=RequestMethod.GET)
	public User getOne(@PathVariable("id")Long id);
}
