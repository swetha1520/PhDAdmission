package com.example.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.repository.UserRepository;
import com.example.springboot.model.User;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository repo;
	
	public User getUserByEmailAndPassword(String email,String password) {
		Optional <User> u=Optional.of(repo.findByEmailAndPassword(email,password));
		return u.get();
	}

}
