package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	/*
	 * By Default, the spring generates the password in the console for development purpose.
	 * UserName is user and password is generated in the console 
	 */

	@GetMapping("/")
	public String getLoginMessage() {
		return "Hi, Welcome to the Team !";
	}

}
