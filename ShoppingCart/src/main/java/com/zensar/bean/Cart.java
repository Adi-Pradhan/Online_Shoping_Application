package com.zensar.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_details")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
//	@ManyToOne
//    @JoinColumn(name="customer_id")
	@Embedded
	private Customer customer;
//	@ManyToOne
//	@JoinColumn(name="product_id")
    @Embedded
	private Product product;
	@Column
	private int quantity;
//	@ManyToMany
//	@Embedded
//	private Map<Product, Integer> productsMap = new HashMap<>();
	
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

		
		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}
		
		public int getQuantity() {
			return quantity;
		}

//		public Map<Product, Integer> getProductsMap() {
//			return productsMap;
//		}
//
//		public void setProductsMap(Map<Product, Integer> productsMap) {
//			this.productsMap = productsMap;
//		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		

		@Override
		public String toString() {
			return "Cart [cartId=" + cartId + ", customer=" + customer + ", product=" + product + ", quantity="
					+ quantity + "]";
		}

		@Override
		public int hashCode() {
		return Objects.hash(cartId);
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
