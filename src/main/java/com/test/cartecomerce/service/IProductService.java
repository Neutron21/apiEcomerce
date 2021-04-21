package com.test.cartecomerce.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.test.cartecomerce.entity.Product;

public interface IProductService {
	
	public List<Product> getAll();
	
	public Product addProduct(Product product);
	
	public Optional<Product> getProdcut(UUID id);
	
	public Product editProduct(Product product);
	
	public void delProduct(UUID id);
}
