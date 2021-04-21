package com.test.cartecomerce.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.test.cartecomerce.entity.Product;

public interface IProductRepository extends CrudRepository<Product, UUID> {

}
