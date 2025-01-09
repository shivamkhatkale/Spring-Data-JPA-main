package com.app.raghu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.app.raghu.entity.Product;
import com.app.raghu.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService service;

	@GetMapping("/register")
	public String showRegPage() {
		return "EmployeeRegister";
	}

	@PostMapping("/save")
	public String saveFormData(@ModelAttribute Product product, Model model) {

		System.out.println(product);
		Integer id = service.saveProduct(product);

		String message = new StringBuffer().append("Product ").append(id).append(" Created").toString();
		model.addAttribute(message);

		return "EmployeeRegister";
	}

	@GetMapping("/all")
	public String displayAllRows(Model model) {

		List<Product> list = service.showAllProduct();
		model.addAttribute("list", list);
		return "EmployeeData";
	}

	@GetMapping("/delete")
	public String deleteRow(@RequestParam("id") Integer empId, RedirectAttributes attributes) {

		service.deleteOneProduct(empId);
		String msg = "Product " + empId + "deleted";
		attributes.addAttribute("message", msg);
		return "redirect:all";

	}

	@GetMapping("/edit")
	public String editRow(@RequestParam("id") Integer pId, Model model) {

		service.getOneProduct(pId);
		return "bookList";
	}

}
