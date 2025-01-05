package com.app.raghu.service;

import java.util.List;

import com.app.raghu.entity.Employee;

public interface IService {

	Integer saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(Integer empId);

	void getOneEmployee(Integer empd);

	List<Employee> getAllEmployee();

}
