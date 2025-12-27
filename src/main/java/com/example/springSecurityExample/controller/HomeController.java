package com.example.springSecurityExample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String getHomePage(HttpServletRequest httpRequest) {
		return "Hello "+ httpRequest.getSession().getId();
	}
	
	
}
