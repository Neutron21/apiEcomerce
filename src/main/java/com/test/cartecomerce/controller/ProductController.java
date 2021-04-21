package com.test.cartecomerce.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import com.test.cartecomerce.entity.Product;
import com.test.cartecomerce.service.IProductService;


@RestController
@RequestMapping("api/")
public class ProductController {
	
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private IProductService productService;
	
	@GetMapping(value = "getAll", produces = "application/json")
	public List<Product> getAllProducts(){
		log.info("In getAll");
		return productService.getAll();
	}
	
	@GetMapping(value = "getbyId/{key}", produces = "application/json")
	public Optional<Product> getOne(@PathVariable("key") String key) {
	
		return productService.getProdcut(UUID.fromString(key));
	}
	
	@PostMapping(value = "addProduct", produces = "application/json")
	public Product creatProduct(@RequestBody Product producto) {
		System.out.println("En controller");
		
		return productService.addProduct(producto);
	}
	
	@PutMapping(value = "putProduct", produces = "application/json")
	public Product puttProduct( @RequestBody Product producto) {
		
		return productService.editProduct(producto);
	}
	
	@PostMapping(value = "delProduct/{key}", produces = "application/json")
	public void delProduct(@PathVariable("key") String key) {
		log.info("In delProduct/"+key);
		productService.delProduct(UUID.fromString(key));
	}

}
