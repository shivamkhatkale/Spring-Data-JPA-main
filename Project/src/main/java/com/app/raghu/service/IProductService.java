package com.app.raghu.service;

import java.util.List;

import com.app.raghu.entity.Product;
import com.app.raghu.exception.ProductNotFoundExceptions;

public interface IProductService {

	Integer saveProduct(Product p);

	void updateProduct(Product p);

	Product getOneProduct(Integer pid) throws ProductNotFoundExceptions;

	void deleteProduct(Integer pid);

	List<Product> getAllProduct(Product p);

	/*
	 * Integer saveEmployee(Employee employee);
	 * 
	 * void updateEmployee(Employee employee);
	 * 
	 * void deleteEmployee(Integer empId);
	 * 
	 * Employee getOneEmployee(Integer empId) throws EmployeeNotFoundException;
	 * 
	 * List<Employee> getAllEmployees();
	 */

}
