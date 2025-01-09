package com.app.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.raghu.entity.Product;
import com.app.raghu.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService service;

	@GetMapping("/register")
	public String registerMethod(Product p) {
		return "EmpRegister";
	}

	@PostMapping("/save")
	public String saveMethod(@ModelAttribute Product product, Model model) {

		Integer id = service.saveProduct(product);
		String message = "Employee " + id + "Created";
		model.addAttribute("message", message);
		return "EmpRegister";

	}

}
