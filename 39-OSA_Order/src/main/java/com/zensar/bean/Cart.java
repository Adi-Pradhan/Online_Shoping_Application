package com.zensar.bean;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Cart {

	@Column(name="cart_id", insertable = false, updatable = false)
	private int cartId;
	@Transient
	private Customer customer;
	//@OneToMany
	//private Map<Product, Integer> products = new HashMap<>();
	@Transient
	private Product product;
	
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public Map<Product, Integer> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Map<Product, Integer> products) {
//		this.products = products;
//	}


	@Override
	public int hashCode() {
		return Objects.hash(cartId);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customer=" + customer + ", product=" + product + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(cartId, other.cartId);
	}
	

}
