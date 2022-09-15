package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.User;
import com.example.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	@Autowired
	private UserRepository userRepository;

	/*
	 * The PostConstruct annotation is used on a method that needs to be executed
	 * after dependency injection is done to perform any initialization. This method
	 * MUST be invoked before the class is put into service. This annotation MUST be
	 * supported on all classes that support dependency injection.
	 */

	@PostConstruct
	public void initUsers() {
		List<User> usersList = new ArrayList<>();
		usersList.add(new User(1, "Nikhil", "pass1"));
		usersList.add(new User(2, "Prabhat", "pass2"));
		userRepository.saveAll(usersList);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
