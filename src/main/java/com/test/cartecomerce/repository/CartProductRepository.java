package com.test.cartecomerce.repository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.cartecomerce.entity.CartProduct;

@Repository
public class CartProductRepository {
	
	Logger log = LoggerFactory.getLogger(ProductRepository.class);
	
	@Autowired
	private ICartProductRepository cartProductRepository;
	
	public List<CartProduct> getAllCart(){
		
		return (List<CartProduct>) cartProductRepository.findAll();
	}
	
	public Optional<CartProduct> getOne(String id) {
		return cartProductRepository.findById(id);
	}
	
	public CartProduct addOrEdit(CartProduct cartProduct){
		
		return cartProductRepository.save(cartProduct);
	}
	
	public void deleteItem(String id) {
		log.info("Del: "+id);
		cartProductRepository.deleteById(id);
	}
	
	public List<CartProduct> saveMany(List<CartProduct> items) {
		
		return (List<CartProduct>) cartProductRepository.saveAll(items);
		
	}
	
	public Float checkOut() {
		
		return cartProductRepository.checkEvent();
		
	}

}
