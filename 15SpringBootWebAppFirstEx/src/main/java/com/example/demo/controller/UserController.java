package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // creating object + HTTP Support
public class UserController {

	// @RequestMapping(value = "/path", method = RequestMethod.GET)
	@GetMapping("/home")
	public String showHomePage() {
		return "UserHome";
	}

}
