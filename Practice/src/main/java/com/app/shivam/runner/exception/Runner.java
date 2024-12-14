package com.app.shivam.runner.exception;

import com.app.shivam.entity.Product;
import com.app.shivam.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private ProductRepository repo;

    @Override
    public void run(String... args) throws Exception {

        Product p = new Product(11, "JavanByHead", 545.0);
        Product p1 = new Product(12, "krak", 5421.0);


//        productRepository.save(p);

        repo.saveAll(List.of(p, p1));


        Iterable<Product> data = repo.findAll();

        // jdk 1.5 forEach loop
        for (Product pr : data) {
            System.out.println(pr);
        }


    }
}
