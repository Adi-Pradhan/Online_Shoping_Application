package com.zensar.bean;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="order1")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private LocalDate orderDate;
	private OrderStatus orderStatus;
	@Embedded
	private Customer customer;
	@Embedded
	private Address address;
	@Embedded
	private Product product;
	//private Map<Product, Integer> productList = new HashMap<>();
	
	//Map<Product, Integer> productList;
	
	public Order() {
		super();
		this.orderDate=LocalDate.now();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	/*public Map<Product, Integer> getProductList() {
		return productList;
	}

	public void setProductList(Map<Product, Integer> map) {
		this.productList = map;
	}*/

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

	public Order(int orderId, LocalDate orderDate, OrderStatus orderStatus, Customer customer, Address address,
			Product product) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.address = address;
		this.product = product;
	}
	
	

	public Order(LocalDate orderDate, OrderStatus orderStatus, Customer customer, Address address, Product product) {
		super();
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.address = address;
		this.product = product;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", customer="
				+ customer + ", address=" + address + ", product=" + product + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderId, other.orderId);
	}


	

}
