package com.app.raghu.service;

import java.util.List;

import com.app.raghu.entity.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer empId);

    Employee getOneEmployee(Integer empId);

    List<Employee> getAllEmployees();
}
