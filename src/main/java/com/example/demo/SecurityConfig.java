package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        	.requestMatchers("/","/home", "/register")
        	.permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login") 
            .permitAll()
            .usernameParameter("username")
            .defaultSuccessUrl("/secret")
            .failureUrl("/login?error=true")
        .and()
        .logout()
        	.logoutUrl("/logout")
        	.logoutSuccessUrl("/");   

		return http.build();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}