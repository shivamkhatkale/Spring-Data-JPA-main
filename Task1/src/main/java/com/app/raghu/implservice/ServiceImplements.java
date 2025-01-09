package com.app.raghu.implservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.raghu.entity.Product;
import com.app.raghu.repository.ProductRepository;
import com.app.raghu.service.IProductService;
import com.app.raghu.util.ProductUtil;

@Service
public class ServiceImplements implements IProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Integer saveProduct(Product p) {

		ProductUtil.CommonCal(p);

		p = repo.save(p);
		return p.getPId();
	}

	@Override
	public void updateProduct(Product p) {
		repo.save(p);
	}

	@Override
	public void getOneProduct(Integer empId) {
		repo.findById(empId);
	}

	@Override
	public List<Product> showAllProduct() {
		List<Product> p = repo.findAll();
		return p;
	}

	@Override
	public void deleteOneProduct(Integer empId) {
		repo.deleteById(empId);

	}

}
