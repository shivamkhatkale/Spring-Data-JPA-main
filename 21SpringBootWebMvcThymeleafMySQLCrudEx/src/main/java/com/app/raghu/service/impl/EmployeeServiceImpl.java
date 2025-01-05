package com.app.raghu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.raghu.entity.Employee;
import com.app.raghu.exception.EmployeeNotFoundException;
import com.app.raghu.repository.EmployeeRepository;
import com.app.raghu.service.IEmployeeService;
import com.app.raghu.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository erepo;

//	@Autowired
//	private EmployeeUtil util; // This is old one here i am using java 8 static method below

	@Override
	public Integer saveEmployee(Employee e) {
		EmployeeUtil.CommonCal(e);
		e = erepo.save(e);
		return e.getEmpId();
	}

	@Override
	public void updateEmployee(Employee e) {
		EmployeeUtil.CommonCal(e);
		erepo.save(e);
	}

	@Override
	public void deleteEmployee(Integer id) {
		erepo.deleteById(id);
	}

	@Override
	public Employee getOneEmployee(Integer id) throws EmployeeNotFoundException {
		return erepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("EMPLOYEE " + id + "NOT FOUND"));
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = erepo.findAll();
		return list;
	}
}
