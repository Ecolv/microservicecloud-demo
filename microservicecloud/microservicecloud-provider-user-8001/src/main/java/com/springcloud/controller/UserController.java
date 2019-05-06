package com.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.User;
import com.springcloud.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/user/list",method=RequestMethod.GET)
	public List<User> list(){
		return service.list();
	}
	
	@GetMapping("/user/get/{id}")
	public User get(@PathVariable("id") Long id) {
		return service.getOne(id);
	}
	
	@GetMapping("/user/discovery")
	public Object discovery() {
		List<String> list = client.getServices();
		List<ServiceInstance> sevInsList = client.getInstances("MISCROSERVICECLOUD-PROVIDER-USER");
		//test
		for (ServiceInstance serviceInstance : sevInsList) {
			System.out.println("serviceId:"+serviceInstance.getServiceId()+"\t"+
					"host:"+serviceInstance.getHost()+"\t"+
					"port:"+serviceInstance.getPort()+"\t"+
					"uri:"+serviceInstance.getUri());
		}
		return this.client;
	}
}
