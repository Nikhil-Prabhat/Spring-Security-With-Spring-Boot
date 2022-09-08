package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.MyUserDetailsService;

@RestController
public class HomeController {

	/*
	 * By Default, the spring generates the password in the console for development
	 * purpose. UserName is user and password is generated in the console
	 */

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@GetMapping("/")
	public String getLoginMessage() {
		return "Hi, Welcome to the Team !";
	}

}
