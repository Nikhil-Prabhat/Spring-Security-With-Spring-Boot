package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity // Enables web security for the application
public class HomeConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * General flow - Controller -> Service -> Dao or Controller -> Configuration ->
	 * Service
	 */

	// We are using service class implementing UserDetailsService as we need this
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);

		// For the time being, don't want to encode the password
		daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return daoAuthenticationProvider;
	}

}
