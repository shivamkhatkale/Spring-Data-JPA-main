package com.app.raghu.service;

import java.util.List;

import com.app.raghu.entity.Product;

public interface IProductService {

	public Integer saveProduct(Product e);

	public void updateProduct(Product e);

	public void getOneProduct(Integer empId);

	public void deleteOneProduct(Integer empId);

	public List<Product> showAllProduct();

}
