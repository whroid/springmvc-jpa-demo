package com.whroid.ee.test.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whroid.ee.test.springmvc.entity.User;
import com.whroid.ee.test.springmvc.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	public UserRepository userRepository;
	
	
	public User getUser(String id)
	{
		User user = userRepository.findOne(id);
		return user;
	}
	
	public List<User> getUser()
	{
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public User save(User user)
	{
		return userRepository.save(user);
	}
}
