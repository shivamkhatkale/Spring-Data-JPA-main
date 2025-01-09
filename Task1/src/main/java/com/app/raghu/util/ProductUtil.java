package com.app.raghu.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;

import com.app.raghu.entity.Product;

// After java 8 (static methods and default methods)
///@Component
//public class EmployeeUtil {

public interface ProductUtil {

	public static void CommonCal(Product p) {
		double hra = p.getPSal() * (12.0 / 100);
		double ta = p.getPSal() * (4.0 / 100);
		p.setPHra(hra);
		p.setPTa(ta);

	}

	public static void createDeptList(Model model) {
		List<String> list = Arrays.asList("DEV", "QA", "BA", "ADMIN", "IT");
		model.addAttribute("deptList", list);
	}

}
