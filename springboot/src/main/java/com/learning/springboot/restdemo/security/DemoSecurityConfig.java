package com.learning.springboot.restdemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class DemoSecurityConfig {
	//Authentication by InMemory Database
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsManager() { UserDetails
	 * john = User.builder() .username("john") .password("{noop}test123")
	 * .roles("EMPLOYER") .build(); UserDetails mary = User.builder()
	 * .username("mary") .password("{noop}test123") .roles("EMPLOYER","MANAGER")
	 * .build(); UserDetails susan = User.builder() .username("susan")
	 * .password("{noop}test123") .roles("EMPLOYER","MANAGER","ADMIN") .build();
	 * return new InMemoryUserDetailsManager(john,mary,susan); }
	 */
	
	//JDBC with no hardcoded users for Authentication
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		//default tables were "users" & "authorities"
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		//query to get username from custom table
		jdbcUserDetailsManager.setUsersByUsernameQuery
			("select user_id,pw,active from members where user_id=?");
		//query to get password from custom table
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery
			("select user_id,role from roles where user_id=?");
		return jdbcUserDetailsManager;
	}
	
	//Authorization
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer ->
				configurer
				.requestMatchers(HttpMethod.GET,"/api/employee").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET,"/api/employee/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST,"/api/employee").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT,"/api/employee/**").hasRole("MANAGER") //** will save you from 403
				.requestMatchers(HttpMethod.DELETE,"/api/employee/**").hasRole("ADMIN")
		);
		//use HTTP basic auth
		http.httpBasic(Customizer.withDefaults());
		//Disable cross site request forgery (CSRF)
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}

	//Hide above Auth & Authorization to enable actuator endpoints
//    @Bean
//    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//		return http.authorizeExchange().pathMatchers("/actuators/**").permitAll()
//				.anyExchange().authenticated().and().build();
//	}
}
