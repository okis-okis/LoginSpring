package com.example.demo;

import lombok.Data;

@Data
public class RegistrationForm {
	private String username;
	private String password;
	
	public User toUser() {
		return new User(username, password);
	}
}
