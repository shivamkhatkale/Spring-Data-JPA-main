package com.app.raghu.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.raghu.entity.Product;
import com.app.raghu.exception.ProductNotFoundExceptions;
import com.app.raghu.repository.ProductRepository;
import com.app.raghu.service.IProductService;

public class ServiceImplementation implements IProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Integer saveProduct(Product p) {
		p = repo.save(p);
		return p.getPId();
	}

	@Override
	public Product getOneProduct(Integer pid) throws ProductNotFoundExceptions {
		return repo.findById(pid)
				.orElseThrow(() -> new ProductNotFoundExceptions("Product with ID " + pid + " not found"));
	}

	@Override
	public List<Product> getAllProduct(Product p) {
		List<Product> ll = repo.findAll();
		return ll;
	}

	@Override
	public void updateProduct(Product p) {
		repo.save(p);
	}

	@Override
	public void deleteProduct(Integer pid) {
		repo.deleteById(pid);
	}

}
