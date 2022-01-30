package br.com.mudi.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.mudi.service.AuthenticationService;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	
	/**
	 * Execute this method to authenticate a user during login.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService(authenticationService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		http
		.authorizeRequests()
			//.antMatchers("/", "/home").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin(form -> form
				.loginPage("/login")
				
				// after success authentication, redirect to this page.
				.defaultSuccessUrl("/home", true)
				.permitAll())
		.logout(logout -> logout.logoutUrl("/logout"));
	}
	
}
