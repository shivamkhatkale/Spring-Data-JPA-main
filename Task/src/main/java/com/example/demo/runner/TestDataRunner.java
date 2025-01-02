package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Component
public class TestDataRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {

		// Creating Product instances with different columns
		Product p1 = new Product(1, "Laptop", "Electronics", 1500.00, 50);
		Product p2 = new Product(2, "Phone", "Electronics", 800.00, 100);
		Product p3 = new Product(3, "Shirt", "Apparel", 25.99, 200);
		Product p4 = new Product(4, "Shoes", "Footwear", 60.50, 150);
		Product p5 = new Product(5, "Watch", "Accessories", 120.00, 70);
		Product p6 = new Product(6, "Phone", "Electronics", 50.75, 30);
		Product p7 = new Product(7, "Headphones", "Electronics", 99.99, 200);
		Product p8 = new Product(8, "Backpack", "Accessories", 40.00, 120);
		Product p9 = new Product(9, "Microwave", "Appliances", 120.00, 40);
		Product p10 = new Product(10, "Phone", "Electronics", 500.00, 10);
		Product p11 = new Product(11, "Table", "Furniture", 80.00, 60);
		Product p12 = new Product(12, "Chair", "Furniture", 40.00, 150);
		Product p13 = new Product(13, "Phone", "Electronics", 30.00, 100);
		Product p14 = new Product(14, "Blender", "Appliances", 25.00, 80);
		Product p15 = new Product(15, "Book", "Books", 15.00, 300);

		//repo.save(p1);
		repo.saveAll(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));

		System.out.println("------------------------------");

		List<Product> ll = repo.findByProduct(50.00);
		ll.forEach(System.out::println);

		List<Product> ll2 = repo.findByCategory("Appliances");
		ll2.forEach(System.out::println);

		System.out.println("------------------------------");

//		List<Product> ll3 = repo.findBySpecificCatAndName("Electronics", "Phone");
//		ll3.forEach(System.out::println);

		Object ll4 = repo.findByCount();
		System.out.println(ll4);
//
//		List<Product> ll5 = repo.findByPriceRange(50.0, 200.0);
//		ll5.forEach(System.out::println);

	}

}
