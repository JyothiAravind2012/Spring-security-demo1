package com.example.springSecurityExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springSecurityExample.modal.User;
import com.example.springSecurityExample.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
		
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return userService.verify(user);
	}

}
