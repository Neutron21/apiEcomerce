package com.test.cartecomerce.entity;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.test.cartecomerce.util.StateProductCart;

@Entity
@Table(name = "Product_Cart")
public class CartProduct {
	
	@Id
	private String uid;
	
	private String nombre;
	
	private Integer cantidad;
	
	private String descripcion;
	
	private Float precio;
	
	private StateProductCart estado;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public StateProductCart getEstado() {
		return estado;
	}

	public void setEstado(StateProductCart estado) {
		this.estado = estado;
	}	
	public void fillData(Optional<Product> product) {
		this.uid = product.get().getUid().toString();
		this.nombre = product.get().getNombre();
		this.cantidad = 1;
		this.descripcion = product.get().getDescripcion();
		this.precio = product.get().getPrecio();
		this.estado = StateProductCart.PENDIENTE;
		}
	
}
