package com.test.cartecomerce.util;

import lombok.Getter;

public enum StateProductCart {
	
	PENDIENTE("Pend", "En espera"),
	
	COMPLETADO("Comp", "Producto despachado");
	
	@Getter
	private String code;
	
	@Getter
	private String descripcion;

	StateProductCart(String code, String descripcion) {
	
		this.code = code;
		this.descripcion = descripcion;
		
	}

}
