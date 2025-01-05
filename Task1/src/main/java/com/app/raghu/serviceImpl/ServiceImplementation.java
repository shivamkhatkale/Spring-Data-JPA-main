package com.app.raghu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.raghu.entity.Employee;
import com.app.raghu.repository.EmployeeRepository;
import com.app.raghu.service.IService;

@Service
public class ServiceImplementation implements IService {

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
	public void updateEmployee(Employee e) {
		erepo.save(e);

	}

	@Override
	public void deleteEmployee(Integer empId) {
		erepo.deleteById(empId);

	}

	@Override
	public void getOneEmployee(Integer empId) {
		erepo.findById(empId);

	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = erepo.findAll();
		return list;
	}

}
