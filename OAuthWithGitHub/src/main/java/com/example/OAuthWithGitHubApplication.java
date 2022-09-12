package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OAuthWithGitHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthWithGitHubApplication.class, args);
	}
	
	@GetMapping("/output")
	public String getOutput()
	{
		return "Welcome to the Oauth Application";
	}

}
