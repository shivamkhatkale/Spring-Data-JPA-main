package com.example.demo.runner;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Product;
import com.example.demo.repository.EmployeeRepository;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {

		Employee e1 = new Employee(11, "Shivam");
		Employee e2 = new Employee(12, "Rushikesh");
		Employee e3 = new Employee(13, "Khatkale");

		repo.saveAll(List.of(e1, e2, e3));

		List<Product> ll = repo.findByPriceRange(50.0, 200.0);
		ll.forEach(System.out::println);

	}

}
