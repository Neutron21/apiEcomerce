package com.test.cartecomerce.service;

import java.util.List;

import com.test.cartecomerce.entity.CartProduct;
import com.test.cartecomerce.model.Cart;

public interface ICartService {
	
	public List<CartProduct> getCart();
	
	public List<CartProduct> addItem(String id);
	
	public CartProduct editItem(CartProduct cProduct);
	
	public void delItem(String id);
	
	public Cart checkout();
}
