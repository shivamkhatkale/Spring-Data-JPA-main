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

import com.app.raghu.entity.Employee;
import com.app.raghu.service.IService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IService service;

	@GetMapping("/register")
	public String showData() {

		return "EmployeeRegister";
	}

	@PostMapping("/save")
	public String saveFormData(@ModelAttribute Employee employee, Model model) {

		Integer id = service.saveEmployee(employee);
		String message = new StringBuffer().append("EMPLOYEE '").append(id).append("' CREATED").toString();
		// "EMPLOYEE '"+id+"' CREATED";
		model.addAttribute("message", message);

		return "EmployeeRegister";

	}
	
	

	// 3. Display all rows as a table
	@GetMapping("/all")
	public String dispalyAllRows(
				Model model, // Model used to pass the data controller method to view 
				@RequestParam(value = "message", required = false) String message
			) {
		List<Employee> list = service.getAllEmployee();
		model.addAttribute("list", list);
		return "EmployeeData";
	}

	// 4. Delete based on id	
	@GetMapping("/delete")
	public String deleteId(
			@RequestParam("id") Integer empId, 
			RedirectAttributes attributes) { // Redirect used to pass data one controller method to another controller method
		service.deleteEmployee(empId);
		String msg = "Employee '" + empId + " deleted ";
		System.out.println(msg);
		attributes.addAttribute("message",msg);
		return "redirect:all";
	}
	
	
	
	
	

}
