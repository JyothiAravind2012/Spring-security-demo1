package com.example.springSecurityExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springSecurityExample.modal.User;
import com.example.springSecurityExample.modal.UserPrincipal;
import com.example.springSecurityExample.repo.UserRepos;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepos userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUserName(username);
		if(user==null) {
			System.out.println("Username not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new UserPrincipal(user);
	}

}
