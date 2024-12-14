package com.app.shivam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.app.shivam.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
