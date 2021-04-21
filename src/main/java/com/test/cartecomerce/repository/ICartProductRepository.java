package com.test.cartecomerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.test.cartecomerce.entity.CartProduct;

public interface ICartProductRepository extends CrudRepository<CartProduct, String> {
	
	@Query(value = "SELECT SUM(precio*cantidad) FROM Product_Cart", nativeQuery = true)
	public Float checkEvent();
}
