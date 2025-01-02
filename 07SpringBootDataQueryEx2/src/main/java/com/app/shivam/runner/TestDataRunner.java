package com.app.shivam.runner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.shivam.entity.Book;
import com.app.shivam.repository.BookRepository;

@Component
public class TestDataRunner implements CommandLineRunner {

	@Autowired
	private BookRepository repo;

	@Override
	public void run(String... args) throws Exception {

		repo.saveAll(Arrays.asList(

				new Book(101, "SBMS", "RAGHU", 300.0, "Backend"), new Book(102, "core", "RAGHU", 200.0, "Backend"),
				new Book(103, "ADV", "ASHOK", 400.0, "Backend"), new Book(104, "REACT", "ASHOK", 500.0, "Frontend"),
				new Book(105, "HTML", null, 600.0, "Backend"), new Book(106, "Angular", "Ashok", 300.0, "Frontend"),
				new Book(107, "Angular", "Ajay", 800.0, "Frontend")));

//		repo.getBooksByAuthor("RAGHU").forEach(System.out::println);
//
//		System.out.println("=============================================");
//
//		// repo.getBooksByAuthorLikeBookCost("RAGHU", 200.0).
//
//		repo.getListofBookId(Arrays.asList(103, 104, 106)).forEach(System.out::println);
//
//		repo.findBybookTypeLike("F%").forEach(System.out::println);
//
//		System.out.println("My book i .....");
//
//		Book bybook = repo.findBybook(105);
//		System.out.println(bybook);
//
//		System.out.println("===============================");
//
//		List<Object[]> bb = repo.findByAllBook();
//		bb.stream()
//		   .map(arr -> "Book Name: " + arr[0] + ", Author: " + arr[1])  // Map to a formatted string
//		   .forEach(System.out::println);  // Print each formatted string
//		

		System.out.println("==============================================");

		List<Book> byAuthorName = repo.findByAuthorName("Ashok");
		byAuthorName.forEach(System.out::println);

	}

}
