package com.ashokit.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.ashokit.raghu.entity.Employee;
import com.ashokit.raghu.repostiory.EmployeeRepository;

//@Component
//@Order(20)
public class TestDataFetchRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {

//		Iterable<Employee> list = repo.findAll();
//		list.forEach(System.out::println);
//
//		// ----case 1 -- 1 column -- ASC Order
//		Iterable<Employee> list1 = repo.findAll(Sort.by(Direction.ASC, "empSal"));
//		list1.forEach(System.out::println);
//
//		// ----case 2 -- 1 column -- DESC Order
//		Iterable<Employee> list2 = repo.findAll(Sort.by(Direction.DESC, "empSal"));
//		list2.forEach(System.out::println);
//
//		// ----case 3 -- Multiple columns -- ASC Order
//		Iterable<Employee> list3 = repo.findAll(Sort.by("empSal", "empDept")); // Order by empSal ASC, empDept ASC
//		list3.forEach(System.out::println);
//
//		// ----case 3 -- n column -- SAME ORDER
//		Iterable<Employee> list4 = repo.findAll(Sort.by(Direction.DESC, "empSal", "empDept"));
//		list4.forEach(System.out::println);

		// ----case4 -- n column --Mixed Order
		// repo.findAll(Sort.by(Order.asc("empSal"),
		// Order.desc("empDept"))).forEach(System.out::println);

//		Iterable<Employee> list5 = repo.findAll(Sort.by(Direction.DESC, "empSal", "empDept"));
//		list5.forEach(System.out::println);

		Iterable<Employee> l1 = repo.findAll(Sort.by("empName"));
		l1.forEach(System.out::println);

		repo.findAll(Sort.by(Sort.Order.asc("empName"))).forEach(System.out::println);

	}
}
