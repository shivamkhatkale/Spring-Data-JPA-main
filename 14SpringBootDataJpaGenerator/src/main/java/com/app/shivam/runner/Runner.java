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

		Product p = new Product();
		p.setProdName("PEN");
		p.setProdCost(111.00);

		p = repo.save(p);
		System.out.println(p.getProdId());
	}
}
