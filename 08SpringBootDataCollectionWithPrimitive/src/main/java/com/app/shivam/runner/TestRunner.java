package com.app.shivam.runner;

import com.app.shivam.entity.Product;
import com.app.shivam.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private ProductRepository repo;

    @Override
    public void run(String... args) throws Exception {

        Product pob = new Product();
        pob.setProdId(10);
        pob.setProdCode("PEN");

        pob.setColors(Arrays.asList("RE", "GR", "BL"));
        // pob.setColors(List.of("RE","GR","BL"));

        Set<String> set = new LinkedHashSet<>();
        set.add("M1");
        set.add("LA");
        set.add("SF");

        pob.setModels(set);

        Map<String, String> map = new LinkedHashMap<>();
        map.put("D1", "ABC");
        map.put("D2", "XYZ");

        pob.setDetails(map);

        repo.save(pob);

    }

}
