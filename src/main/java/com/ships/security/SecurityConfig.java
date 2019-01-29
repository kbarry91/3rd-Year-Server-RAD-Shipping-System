/**
 * 
 */
package com.ships.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author G00339811 {@link SecurityConfig} Adds security to restrict
 *         unauthorized access
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		// URLs on which spring security should be applied
		httpSecurity.authorizeRequests().antMatchers("/addShip", "/addShippingCompany", "/createOrder").hasRole("USER")
				.and().formLogin();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user")// username is "user"
				.password("user") // password is "user"
				.roles("USER");// spring security role
	}
}
