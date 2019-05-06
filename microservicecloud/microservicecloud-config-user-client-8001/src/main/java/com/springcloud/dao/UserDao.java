package com.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springcloud.entity.User;

@Mapper
public interface UserDao {
	public List<User> getAll();
	public User getOne(Long id);
}
