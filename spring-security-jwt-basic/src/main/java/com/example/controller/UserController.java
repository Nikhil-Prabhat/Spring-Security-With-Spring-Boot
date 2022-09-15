package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AuthRequest;
import com.example.util.JWTUtil;

@RestController
public class UserController {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String getWelcomeMessage() {
		return "Hi , Welcome !";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			// Authenticate credentials
			// If credentials are right, only then generate token
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid Username/Password");
		}

		// JWT token creation
		return jwtUtil.generateToken(authRequest.getUsername());
	}
	

}
