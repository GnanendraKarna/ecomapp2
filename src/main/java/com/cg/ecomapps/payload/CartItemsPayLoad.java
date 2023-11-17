package com.cg.ecomapps.payload;



	public class CartItemsPayLoad {
		
		private int customerId;
		
		private int productId;
		
		private int cartItemsQuantity;
		
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public int getCartItemsQuantity() {
			return cartItemsQuantity;
		}
		public void setCartItemsQuantity(int cartItemsQuantity) {
			this.cartItemsQuantity = cartItemsQuantity;
		}
		
	}



