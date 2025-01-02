package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Product;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT p FROM Pd890 p WHERE p.price BETWEEN :minPrice AND :maxPrice")
	List<Product> findByPriceRange(Double minPrice, Double maxPrice);


	
	
}
