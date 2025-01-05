package com.app.raghu.util;

import com.app.raghu.entity.Employee;

// After java 8 (static methods and default methods)
///@Component
//public class EmployeeUtil {

public interface EmployeeUtil{

	public static void CommonCal(Employee e) {
		double hra = e.getEmpSal() * (12.0 / 100);
		double ta = e.getEmpSal() * (4.0 / 100);
		e.setEmpHra(hra);
		e.setEmpTa(ta);
		
	}
	
	
}
