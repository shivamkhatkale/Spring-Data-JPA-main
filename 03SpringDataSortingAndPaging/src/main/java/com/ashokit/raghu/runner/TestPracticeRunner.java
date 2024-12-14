package com.ashokit.raghu.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashokit.raghu.entity.Employee;
import com.ashokit.raghu.repostiory.EmployeeRepository;

@Component
public class TestPracticeRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	public void run(String... args) throws Exception {

		System.out.println("All Employee Fetch");

		Iterable<Employee> list = repo.findAll();
		list.forEach(System.out::println);

		System.out.println("============");

		boolean existsById = repo.existsById(11);
		System.out.println(existsById);

		long count = repo.count();
		System.out.println(count);

		Optional<Employee> byId = repo.findById(3234);
		byId.ifPresentOrElse(employee -> System.out.println(employee), () -> System.out.println("Employee not found"));

	}

}
