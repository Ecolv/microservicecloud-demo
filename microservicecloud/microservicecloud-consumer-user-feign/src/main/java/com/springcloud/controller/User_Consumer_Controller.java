package com.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.User;
import com.springcloud.service.UserClientService;

@RestController
public class User_Consumer_Controller {
	@Autowired
	private UserClientService service;
	
	@RequestMapping(value="/consumer/list")
	public List<User> list(){
		return this.service.list();
	}
	
	@RequestMapping(value="/consumer/get/{id}")
	public User get(@PathVariable("id")Long id) {
		return this.service.getOne(id);
	}
}
