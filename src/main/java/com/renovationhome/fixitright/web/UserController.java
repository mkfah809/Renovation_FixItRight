package com.renovationhome.fixitright.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.renovationhome.fixitright.domain.User;
import com.renovationhome.fixitright.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;
	@GetMapping("/home")
	String getHome(ModelMap model) {
		model.put("user", new User());
		return "home";
	}

	@PostMapping("/home#")
	String postUser(User user) {
		userRepo.save(user);
		
//		https://www.geeksforgeeks.org/spring-boot-sending-email-via-smtp/
		return "redirect:/home";
	}
}
