package com.test.cartecomerce.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.cartecomerce.entity.Product;
import com.test.cartecomerce.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService implements IProductService {
	
	Logger log = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {

		return productRepository.listarProductos();
	}

	@Override
	public Product addProduct(Product product) {
		
		System.out.println("En service");
		return  productRepository.crearProduct(product);

	}

	@Override
	public Optional<Product> getProdcut(UUID id) {
		return productRepository.getByKey(id);

	}
	@Override
	public Product editProduct(Product product) {
		
		return productRepository.crearProduct(product);
	}

	@Override
	public void delProduct(UUID id) {
		
		productRepository.delProduct(id);
	}
	

}
