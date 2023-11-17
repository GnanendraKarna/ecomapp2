
	package com.cg.ecomapps.entity;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table(name="cart_items_table")
	public class CartItems {
		
		@Id
		@Column(name="cart_items_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int cartItemsId;
		
		@Column(name="cart_items_quantity")
		private int cartItemsQuantity;
		
		@Column(name="cart_items_total")
		private double cartItemsTotal;

		@OneToOne
		@JoinColumn(name="product_id")
		private Product product;
		
		@ManyToOne
		@JoinColumn(name="cart_id")
	    @JsonIgnore
		private Cart cart;

		public int getCartItemsId() {
			return cartItemsId;
		}

		public void setCartItemsId(int cartItemsId) {
			this.cartItemsId = cartItemsId;
		}

		public int getCartItemsQuantity() {
			return cartItemsQuantity;
		}

		public void setCartItemsQuantity(int cartItemsQuantity) {
			this.cartItemsQuantity = cartItemsQuantity;
		}

		public double getCartItemsTotal() {
			return cartItemsTotal;
		}

		public void setCartItemsTotal(double cartItemsTotal) {
			this.cartItemsTotal = cartItemsTotal;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}
		
	}


