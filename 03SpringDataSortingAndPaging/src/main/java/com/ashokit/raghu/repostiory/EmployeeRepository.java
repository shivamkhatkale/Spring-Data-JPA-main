package com.ashokit.raghu.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.raghu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
