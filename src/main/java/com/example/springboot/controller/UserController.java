package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.service.UserService;
import com.example.springboot.model.User;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	public UserService service;
	
	@PostMapping("/addUser")
	public void addDetails(@RequestBody User u) {
			service.saveUser(u);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> findAllUsers(){
		return service.getUsers();	
	}
	
	@GetMapping("/getUser?id={id}")
	public User getUserByIdDetails(@PathVariable int id) {
		return service.getUserById(id);
	}
	
	@PutMapping("/updateUser?id={id}")
	public User updateId(@RequestBody User u) {
		return service.UpdateById(u);
	}
	
	@PutMapping("/updateUser?name={username}")
	public User update(@RequestParam("username") String username,@RequestBody User u) {
		return service.updatename(username,u);
	}
	@DeleteMapping("/deleteUser?name={username}")
	public String delete(@RequestParam("username") String username) {
		return service.deletename(username);
	}
	
	@DeleteMapping("/deleteUser?id={id}")
	public String deleteId(@PathVariable int id) {
		return service.deleteById(id);
	}
}

