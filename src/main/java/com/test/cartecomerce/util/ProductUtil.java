package com.test.cartecomerce.util;

import com.test.cartecomerce.entity.Product;

public final class ProductUtil {

	public final static Integer DISC = 2;
	public final static Character DES = 'D';
	public final static Character SIM = 'S';
	/**
	 * Metodo para hacer desucento en un producto
	 * @param prod
	 * @return prod
	 */
	public static Product discount(Product prod) {
		
		if(SIM.equals(prod.getTipo())) {
			
			Float priceDiscount = prod.getPrecio() / DISC;
			prod.setPrecio(priceDiscount);
			prod.setTipo(DES);
			
		}
		return prod;
		
	}
	
	/**
	 * Metodo para quitar el desucento en un producto
	 * @param prod
	 * @return prod
	 */
	public static Product nonDiscount(Product prod) {
		
		if(DES.equals(prod.getTipo())) {
			
			Float priceDiscount = prod.getPrecio() * DISC;
			prod.setPrecio(priceDiscount);
			prod.setTipo(SIM);
		}
		return prod;
	}
	
}
