package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	// 1. Select products with a price greater than a specific value (e.g., 100).
	@Query("FROM Product e WHERE e.price > :price")
	List<Product> findByProduct(Double price);

	// 2. Select products by category (e.g., "Electronics").
	@Query("FROM Product e WHERE e.category =:category")
	List<Product> findByCategory(String category);

	// 3. Select products that belong to a specific category and have a specific
	// name (e.g., "Phone" in "Electronics").
	// @Query("FROM Product e WHERE e.category =:category AND e.productName =:Name")
	// List<Product> findBySpecificCatAndName(String category, String Name);

	// 4. Count the number of products in a specific category (e.g., "Appliances").
	@Query("SELECT count(p.productName) FROM Product p")
	Object findByCount();

//	@Query("FROM PRODUCT where price >fprice AND price <sprice")
//	List<Product> findByPriceRange(Double fprice, Double sprice);

}
