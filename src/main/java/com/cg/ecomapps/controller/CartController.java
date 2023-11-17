package com.cg.ecomapps.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecomapps.entity.Cart;
import com.cg.ecomapps.payload.CartItemsPayLoad;
import com.cg.ecomapps.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/additem")
	public ResponseEntity<Cart> saveItemToCart(@RequestBody CartItemsPayLoad cartItemPayLoad)
	{
		Cart newCart=
				cartService.addItemToCart(cartItemPayLoad.getCustomerId(), cartItemPayLoad.getProductId(), cartItemPayLoad.getCartItemsQuantity());
	
		return new ResponseEntity<>(newCart,HttpStatus.CREATED);
		
	}
	///its karnas
	
	@DeleteMapping("/deleteItem/{customerId}/{cartItemId}")
	public ResponseEntity<Cart> deleteFromCart(@Valid @PathVariable int customerId, @Valid @PathVariable int cartItemId){
		Cart cart=cartService.removeItemFromCart(customerId, cartItemId);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	

}
