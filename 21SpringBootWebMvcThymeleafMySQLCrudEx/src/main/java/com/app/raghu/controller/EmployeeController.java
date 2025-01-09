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
import com.app.raghu.exception.EmployeeNotFoundException;
import com.app.raghu.service.IEmployeeService;
import com.app.raghu.util.EmployeeUtil;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	/***
	 * 1. SHOW REGISTER PAGE This method is used to display Register Page when
	 * end-user enters /register with GET Type
	 */
	@GetMapping("/register")
	public String showRegPage(Model model) {
		// For Dynamic DropDown
		EmployeeUtil.createDeptList(model);
		return "EmployeeRegister";
	}

	/**
	 * 2. ON CLICK FORM SUBMIT, READ DATA (@MODELATTRIBUTE) This method is used to
	 * read Form data as Model Attribute It will make call to service method by
	 * passing same form object Service method returns PK(ID). Controller returns
	 * String message back to UI using Model
	 * 
	 * @param employee
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String saveFormData(@ModelAttribute Employee employee, Model model) {
		System.out.println(employee);
		Integer id = service.saveEmployee(employee);

		String message = new StringBuffer().append("EMPLOYEE '").append(id).append("' CREATED").toString();
		// "EMPLOYEE '"+id+"' CREATED";
		model.addAttribute("message", message);

		// For Dynamic DropDown
		EmployeeUtil.createDeptList(model);
		return "EmployeeRegister";
	}

	// 3. Display all rows as a table
	@GetMapping("/all")
	public String dispalyAllRows(Model model, // Model used to pass the data controller method to view
			@RequestParam(value = "message", required = false) String message) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}

	// 4. Delete based on id
	@GetMapping("/delete")
	public String deleteId(@RequestParam("id") Integer empId, RedirectAttributes attributes) {
		// Redirect used to pass data one controller method to another controller method
		service.deleteEmployee(empId);
		String msg = "Employee '" + empId + " deleted ";
		System.out.println(msg);
		attributes.addAttribute("message", msg);
		return "redirect:all";
	}

	// 5. On Click Edit Link(HyperLink) Show data in Edit Form
	@GetMapping("/edit")
	public String showEdit(@RequestParam("id") Integer empId, Model model, RedirectAttributes attributes)
			throws EmployeeNotFoundException {

		String page = null;
		try {
			Employee employee = service.getOneEmployee(empId);
			model.addAttribute("employee", employee);
			// For Dynamic DropDown
			EmployeeUtil.createDeptList(model);
			page = "EmployeeEdit";
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}

	// 6. Update Form data and submit

	@PostMapping("/update")
	public String updateData(@ModelAttribute Employee employee, RedirectAttributes attributes) {

		service.updateEmployee(employee);
		attributes.addAttribute("message", "Employee " + employee.getEmpId() + "updated");
		return "redirect:all";

	}

}
