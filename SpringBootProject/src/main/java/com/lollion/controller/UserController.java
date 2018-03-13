package com.lollion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lollion.service.UserService;

import model.User;

@RestController
public class UserController {

	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value="/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	@RequestMapping(method=RequestMethod.GET, value="/users/{id}")
	public Optional<User> getUserById(@PathVariable String id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public void updateUser(@PathVariable String id, @RequestBody User user) {
		userService.updateUser(id, user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
}
