package com.app.shivam.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.app.shivam.entity.Product;
import jakarta.transaction.Transactional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Transactional // we need to define on top of service layer
	@Modifying
	@Query("UPDATE Product SET prodName =:prodName WHERE prodId =:prodId")
	int updateNameById(String prodName, Integer prodId);

	@Transactional // we need to define on top of service layer
	@Modifying
	@Query("DELETE FROM Product WHERE prodId = :pid")
	int deleteByProdId(Integer pid);

}
