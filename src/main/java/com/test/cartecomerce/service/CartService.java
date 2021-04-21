package com.test.cartecomerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.cartecomerce.entity.CartProduct;
import com.test.cartecomerce.entity.Product;
import com.test.cartecomerce.model.Cart;
import com.test.cartecomerce.repository.CartProductRepository;
import com.test.cartecomerce.repository.ProductRepository;
import com.test.cartecomerce.util.StateProductCart;

@Service
public class CartService implements ICartService {
	
	Logger log = LoggerFactory.getLogger(CartService.class);
	
	@Autowired
	private CartProductRepository cartProductRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<CartProduct> getCart() {

		return cartProductRepository.getAllCart();
	}

	@Override
	public List<CartProduct> addItem(String id) {
		log.info("En AddItem");
		if(!ifExist(id)) {
			Optional<Product> product = productRepository.getByKey(UUID.fromString(id));
			CartProduct cProduct = new CartProduct();
			cProduct.fillData(product);
			log.info("Pasa le Fill ");
			
			cartProductRepository.addOrEdit(cProduct);
		}
		
		return cartProductRepository.getAllCart();
	}

	@Override
	public CartProduct editItem(CartProduct cProduct) {
		
		log.info("Cantidad: "+cProduct.getCantidad());
		if(cProduct.getCantidad() == 0) {
			log.info("ZERO Quantity : Se elimina del Cart");
			String id = cProduct.getUid();

			delItem(id);
		} else {
			cartProductRepository.addOrEdit(cProduct);
		}
		
		return cProduct;
	}

	@Override
	public void delItem(String id) {
		
		cartProductRepository.deleteItem(id);
	}

	@Override
	public Cart checkout() {
		Cart cart = new Cart();
		
		cart.setCosto(cartProductRepository.checkOut());
		cart.setItems(changeStatus(getCart()));
		log.info("CHECKOUT");
		log.info("Cart Total: "+ cart.getCosto());
		log.info("Cart Lista: "+ cart.getItems().size());
		
		return cart;
	}
	
	private List<CartProduct> changeStatus(List<CartProduct> cart) {
		
		List <CartProduct> items = new ArrayList<CartProduct>();
		for (CartProduct cartProduct : cart) {
			cartProduct.setEstado(StateProductCart.COMPLETADO);
			cartProductRepository.addOrEdit(cartProduct);
			items.add(cartProduct);
		}
		return items;
	}

	public Boolean ifExist(String id) {
		
		Optional<CartProduct> cartProd = cartProductRepository.getOne(id);
		Boolean existe = false;
		log.info("IfExist: "+cartProd.isEmpty());
		try {
			if(cartProd.get() != null) {
				log.info("Producto ya existe en el carrito");
				
				CartProduct prod = cartProd.get();
				prod.setCantidad(cartProd.get().getCantidad() + 1);
				cartProductRepository.addOrEdit(prod);
				
				existe = true;
			}
		} catch (Exception e) {
			log.info("No existe, se agregara al Cart");
		}
		
		return existe;
		
	}

}
