package com.cg.ecomapps.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecomapps.entity.Cart;
import com.cg.ecomapps.entity.CartItems;
import com.cg.ecomapps.entity.Customer;
import com.cg.ecomapps.entity.Product;
import com.cg.ecomapps.exception.ResourceNotFoundException;
import com.cg.ecomapps.repository.CartItemsRepository;
import com.cg.ecomapps.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartItemsRepository cartItemRepository;
	@Override
	public Cart addItemToCart(int customerId, int productId, int quantity) {
		
		Product product=productService.findProductById(productId);
		Customer customer=customerService.getCustomerById(customerId);
		Cart cart=customer.getCart();
		Set<CartItems> cartItems=cart.getCartItems();
		CartItems cartItem= new CartItems();
		cartItem.setProduct(product);
		cartItem.setCartItemsQuantity(quantity);
		cartItem.setCartItemsTotal(product.getProductPrice()*quantity);
		cartItems.add(cartItem);
		cartItem.setCart(cart);
		cart.setCartTotal(calculatorCartTotal(cart));
		cartRepository.save(cart);
		return cart;
	}

	@Override
	public Cart removeItemFromCart(int customerId, int cartItemId) {
		
		Customer customer=customerService.getCustomerById(customerId);
		Cart cart =customer.getCart();
		Set<CartItems> cartItems=cart.getCartItems();
		Optional<CartItems> optionalCartItem=cartItemRepository.findById(cartItemId);
		if(optionalCartItem.isEmpty()) {
			throw new ResourceNotFoundException("not found the item with CartItemId"+cartItemId);
		}
		CartItems cartItem=optionalCartItem.get();
		boolean flag=false;
		for(CartItems item:cartItems) {
			if(item.getCartItemsId()==cartItem.getCartItemsId()) {
				cartItems.remove(cartItem);
				flag=true;
				break;
			}
		}
		if(flag==false) {
			throw new ResourceNotFoundException("not found the item with CartItemId");
		}
		cart.setCartTotal(calculatorCartTotal(cart));
		cartRepository.save(cart);
		return cart;
	}
		
		
		
		
		
		
	
private double calculatorCartTotal(Cart cart) {
	double carttotal=0;
	Set<CartItems>cartItems=cart.getCartItems();
	for(CartItems item:cartItems) {
		carttotal+=item.getCartItemsTotal();
		
	}
	return carttotal;
	
}
}
