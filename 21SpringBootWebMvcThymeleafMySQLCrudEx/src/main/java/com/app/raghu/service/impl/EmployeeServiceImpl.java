package com.app.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.raghu.entity.Employee;
import com.app.raghu.repository.EmployeeRepository;
import com.app.raghu.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository erepo;

	@Override
	public Integer saveEmployee(Employee e) {
		double hra = e.getEmpSal() * (12.0 / 100);
		double ta = e.getEmpSal() * (4.0 / 100);
		e.setEmpHra(hra);
		e.setEmpTa(ta);
		e = erepo.save(e);
		return e.getEmpId();
	}

	@Override
	public void updateEmployee(Employee employee) {
		erepo.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		erepo.deleteById(id);

	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> e = erepo.findById(id);
		return e.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = erepo.findAll();
		return list;
	}
}
