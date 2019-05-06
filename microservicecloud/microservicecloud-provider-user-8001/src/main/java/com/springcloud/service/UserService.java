package com.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.dao.UserDao;
import com.springcloud.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	
	public List<User> list(){
		return dao.getAll();
	}
	
	public User getOne(Long id) {
		return dao.getOne(id);
	}
}
