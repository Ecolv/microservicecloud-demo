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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
	
	@RequestMapping(value="/user/get/{id}",method=RequestMethod.GET)
	//调用服务方法失败并抛出错误信息,会自动调用@HystrixCommand标注好的fallbackMethod
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	public User get(@PathVariable("id") Long id) {
		User user = service.getOne(id);
		if (user == null) {
			throw new RuntimeException("该ID:"+id+"不存在该用户");
		}
		return user;
	}
	
	public User processHystrix_Get(@PathVariable("id") Long id) {
		User user = new User();
		user.setId(id);
		user.setPassword(null);
		user.setUname("不存在该用户");
		user.setDb_source("no this database");
		return user;
	}
	
	@GetMapping("/user/getInfo")
	public User getInfo() {
		User user = new User(1L, "ww", "qq", "aa");
		return user;
	}
	
	@GetMapping("/user/discovery")
	public Object discovery() {
//		List<String> list = client.getServices();
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
