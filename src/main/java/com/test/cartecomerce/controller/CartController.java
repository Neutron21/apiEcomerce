/**
 * 
 */
package com.test.cartecomerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.cartecomerce.entity.CartProduct;
import com.test.cartecomerce.model.Cart;
import com.test.cartecomerce.service.ICartService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ivanjuarez
 *
 */
@Slf4j

@RestController
@RequestMapping("apiCart/")
public class CartController {
	
	Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private ICartService cartService;
	
		@GetMapping(value = "getCart", produces = "application/json")
		public List<CartProduct> getAllProductsCart(){
			
			return cartService.getCart();
		}
		/**
		 * Add if exist plus one
		 * @param id
		 * @return
		 */
		@PostMapping(value = "addToCart/{key}", produces = "application/json")
		public List<CartProduct> addToCart(@PathVariable("key") String id) {
			log.info("addToCart key: "+id);
			return cartService.addItem(id);
		}
		/**
		 * Add or subtract quantity
		 * @param cProduct
		 * @return
		 */
		@PutMapping(value = "putToCart", produces = "application/json")
		public CartProduct putToCart(@RequestBody CartProduct cProduct) {
			
			return cartService.editItem(cProduct);
		}
		@PostMapping(value = "delToCart/{key}", produces = "application/json")
		public void delToCart(@PathVariable("key") String id) {
			
			cartService.delItem(id);
		}
		
		@GetMapping(value = "getChceckOut", produces = "application/json")
		public Cart getCheckOutCart(){
			
			return cartService.checkout();
		}

}
