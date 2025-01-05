package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class StudentController {

	@GetMapping({ "/login", "/home", "/" })
	public String Login() {
		return "EmpData";
	}

	@GetMapping("/login")
	public String Register() {
		return "EmpRegister";
	}

}
