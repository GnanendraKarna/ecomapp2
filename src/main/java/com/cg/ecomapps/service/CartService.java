package com.cg.ecomapps.service;

import com.cg.ecomapps.entity.Cart;

public interface CartService { 
	Cart addItemToCart(int customerId,int productId,int quantity);
	
	Cart removeItemFromCart(int customerId,int cartItemId);
	

}
