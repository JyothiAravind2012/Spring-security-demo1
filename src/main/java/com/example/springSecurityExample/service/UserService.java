package com.example.springSecurityExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springSecurityExample.modal.User;
import com.example.springSecurityExample.repo.UserRepos;

@Service
public class UserService {

	@Autowired
	private UserRepos userRepo;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtService jwtService;
	

	public User register(User user) {
		user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
		return userRepo.save(user);
	}

	public String verify(User user) {
		System.out.println(user);
		Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUserName());
		}
		return "Fail";
	}

}
