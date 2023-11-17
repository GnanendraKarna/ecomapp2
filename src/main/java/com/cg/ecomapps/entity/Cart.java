package com.cg.ecomapps.entity;


	import java.util.Set;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToMany;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table(name="cart_table")
	public class Cart {
		
		@Id
		@Column(name="cart_id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int cartId;
		
		@Column(name="cart_total")
		private double cartTotal;
		
		@OneToOne
		@JoinColumn(name="customer_id")
		@JsonIgnore
		private Customer customer;
		
		@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval=true)
		private Set<CartItems> cartItems;

		public int getCartId() {
			return cartId;
		}

		public void setCartId(int cartId) {
			this.cartId = cartId;
		}

		public double getCartTotal() {
			return cartTotal;
		}

		public void setCartTotal(double cartTotal) {
			this.cartTotal = cartTotal;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Set<CartItems> getCartItems() {
			return cartItems;
		}

		public void setCartItems(Set<CartItems> cartItems) {
			this.cartItems = cartItems;
		}
		
		

}
