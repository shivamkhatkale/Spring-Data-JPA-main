package com.app.shivam.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.shivam.entity.Product;
import com.app.shivam.repo.ProductRepository;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {

		Product p = new Product(11, "Rushikesh", 111.00);
		repo.save(p);

		// Update the product name by ID
		int updateCount = repo.updateNameById("Shivam", 11);
		System.out.println("Update Operation: Rows affected = " + updateCount);

		// Remove the product by ID
		int deleteCount = repo.deleteByProdId(11);
		System.out.println("Delete Operation: Rows affected = " + deleteCount);

	}
}
