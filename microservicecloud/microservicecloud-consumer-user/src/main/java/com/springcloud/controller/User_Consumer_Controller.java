package com.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.entity.User;

@RestController
public class User_Consumer_Controller {
	@Autowired
	private RestTemplate restTemplate;
//	private static final String REST_URL_PREFIX = "http://localhost:8001";
	//微服务名
	private static final String REST_URL_PREFIX = "http://MISCROSERVICECLOUD-PROVIDER-USER";
	
	@RequestMapping(value="/consumer/get/{id}")
	public User get(@PathVariable("id") Long id ) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/user/get/"+id, User.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/list")
	public List<User> list() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/user/list", List.class);
	}
	
	@RequestMapping(value="/consumer/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/user/discovery", Object.class);
	}
	
	
}
