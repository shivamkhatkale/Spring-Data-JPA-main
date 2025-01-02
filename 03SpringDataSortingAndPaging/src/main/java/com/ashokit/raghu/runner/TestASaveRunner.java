package com.ashokit.raghu.runner;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ashokit.raghu.entity.Employee;
import com.ashokit.raghu.repostiory.EmployeeRepository;

@Component
//@Order(10)
public class TestASaveRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	
	public void run(String... args) throws Exception {
		
		Employee e = new Employee(112, "Shivam", 100.0, "IT");
		repo.save(e);
	
		repo.saveAll(
				//List.of(
				List.of(
						new Employee(10, "AAB", 200.0, "DEV"),
						new Employee(11, "AAB", 200.0, "QA"),
						new Employee(12, "AAB", 200.0, "BA"),
						new Employee(13, "AAB", 300.0, "DEV"),
						new Employee(14, "AAB", 300.0, "QA"),
						new Employee(15, "AAB", 300.0, "BA"),
						new Employee(16, "AAB", 400.0, "DEV"),
						new Employee(17, "AAB", 400.0, "QA"),
						new Employee(18, "AAB", 400.0, "BA")
						)
				);
		
		}
}