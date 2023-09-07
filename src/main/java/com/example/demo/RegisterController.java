package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private UserRepository userRepo;
	
	@GetMapping
	public String registerPage() {
		return "registration";
	}
	
	@PostMapping
	public String registration() {
		return "redirect:login";
	}
}
