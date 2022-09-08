package com.example.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity // Enables web security for the application
public class HomeConfiguration extends WebSecurityConfigurerAdapter {

	// We need object of UserDetailsService, so we have annotated with @Bean
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {

		// UserDetails is from spring security
		// We need to create the users, so we'll be using spring security user class
		// User is the child class of UserDetails
		// UserDetailsService is an interface and is implemented by
		// InMemoryUserDetailsManager class
		List<UserDetails> userList = new ArrayList<>();
		userList.add(User.withDefaultPasswordEncoder()
				.username("Nikhil")
				.password("1234")
				.roles("USER")
				.build());
		return new InMemoryUserDetailsManager(userList);
	}

}
