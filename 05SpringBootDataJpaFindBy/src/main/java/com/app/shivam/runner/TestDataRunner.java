package com.app.shivam.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

//		repo.findByAuthor("Ashok").forEach(System.out::println);
//
//		System.out.println(" ---------------------------------------------------------------------------- ");
//
//		repo.findByBookType("Backend").forEach(System.out::println);
//
//		System.out.println(" ---------------------------------------------------------------------------- ");
//
//		repo.findByBookCostLessThanEqual(300.0).forEach(System.out::println);
//
//		System.out.println(" ---------------------------------------------------------------------------- ");
//
//		repo.findByAuthorIsNull().forEach(System.out::println);
//		
		System.out.println(" ---------------------------------------------------------------------------- ");

//		repo.findByAuthorLike("A%")
//		repo.findByAuthorLike("R%")
//		repo.findByAuthorLike("%R%")
//		repo.findByAuthorLike("%K")
//		repo.findByAuthorLike("_____") // 5 character

		// repo.findByAuthorStartingWith("R")

		// repo.findByAuthorEndingWith("K")

//		repo.findByAuthorContaining("A")

//		repo.findByBookIdLessThanEqualOrBookTypeLike(105,"Front%")

//		repo.findByBookIdNotAndBookTypeNotLike(105, "Front%")
//
//				.forEach(System.out::println);

		System.out.println(" ---------------------------------------------------------------------------- ");

		// repo.findByAuthorLikeOrderByBookNameDesc("A%")

		repo.findByBookIdBetween(102, 105)

				.forEach(System.out::println);

		System.out.println("----------------------------------------------------------------------------------");

		Optional<Book> opt = repo.findByBookId(1050);
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			System.out.println("No Data Found...");
		}

	}

}
