package com.app.raghu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.raghu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Query("______")
	// ReturnType abstractMethodName(<Param>)

	// SQL : 1. fetch one column data
	@Query("SELECT e.empName FROM Employee e")
//	@Query("SELECT empName FROM Employee") 
	List<String> getAllEmpNames();

	// SQL : 2 select * from emptab
	// @Query("SELECT e FROM Employee e")
	@Query("FROM Employee")
	List<Employee> fetchAllEmps();

	// SQL : 3 Select multiple columns
	@Query("SELECT e.empId, e.empName FROM Employee e")
	List<Object[]> fetchIdAndNames();

	// SQL : Fetch one column and one row data
	@Query("SELECT e.empName FROM Employee e WHERE e.empId=:id")
	Optional<String> getEmpNameById(Integer id);

	// SQL : fetch all columns and one row
	@Query("SELECT e FROM Employee e WHERE e.empId=:id")
	Optional<Employee> fetchEmployeeByID(Integer id);

	List<Employee> findByEmpNameStartingWith(String empName);

}
