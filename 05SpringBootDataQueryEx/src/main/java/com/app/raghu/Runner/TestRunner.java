package com.app.raghu.Runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.raghu.entity.Employee;
import com.app.raghu.repository.EmployeeRepository;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {

		repo.saveAll(

				Arrays.asList(

						new Employee(101, "AA", 200.00, "DEV"),
						new Employee(102, "BA", 500.00, "DEV"),
						new Employee(103, "AC", 200.00, "QA"), 
						new Employee(104, "DD", 400.00, "QA"),
						new Employee(105, "EC", 600.00, "DEV")

				)

		);

		// repo.getAllEmpNames()

		// repo.fetchAllEmps()
		
		repo.fetchIdAndNames() // return object[]
			.stream()
			.map(obj -> obj[0] + " : "+ obj[1])
			.forEach(System.out::println);
		
		Optional<String> opt = repo.getEmpNameById(101);
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}else {
			System.out.println("NO DATA FOUND");
		}

		
		Employee e = repo.fetchEmployeeByID(102)
				.orElseThrow(() -> new RuntimeException("Not Found"));
		System.out.println(e);
	
		repo.findByEmpNameStartingWith("A")
			.forEach(System.out::println);
		
		
	}

}