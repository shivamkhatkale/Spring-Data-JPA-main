package com.app.shivam.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.shivam.entiity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
