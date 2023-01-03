package com.renovationhome.fixitright.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/home")
	String getHome() {
		return "home";
	}
}
