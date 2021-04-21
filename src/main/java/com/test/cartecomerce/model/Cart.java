package com.test.cartecomerce.model;

import java.util.List;

import com.test.cartecomerce.entity.CartProduct;

import lombok.Data;
/**
 * @author ivanjuarez
 *
 */
@Data
public class Cart {
	
	private List<CartProduct> items;
	
	private Float costo;

	public List<CartProduct> getItems() {
		return items;
	}

	public void setItems(List<CartProduct> items) {
		this.items = items;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}
	
}
