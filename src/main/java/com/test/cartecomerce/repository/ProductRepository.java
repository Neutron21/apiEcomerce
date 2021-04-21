package com.test.cartecomerce.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.cartecomerce.entity.Product;

@Repository
public class ProductRepository {
	
	Logger log = LoggerFactory.getLogger(ProductRepository.class);

	@Autowired
	private IProductRepository productRepository;
	
	public List<Product> listarProductos(){
		
		return (List<Product>) productRepository.findAll();
	}
	
	public Product crearProduct(Product product){
		
		return productRepository.save(product);
	}
	
	public Optional<Product> getByKey(UUID id) {
		
		return productRepository.findById(id);
	}
	
	public void delProduct(UUID id) {
		
		try {
			productRepository.deleteById(id);
			
		} catch (Exception e) {
			log.info("Error en el borrado: "+e);
		}

	}
}
