package com.zensar.bean;

import java.time.LocalDate;


public class OrderRequest {

	private int orderId;
	private LocalDate orderDate;
	private OrderStatus orderStatus;
	private int customerId;
	private int addressId;
	private int productId;
	
	
	
	public OrderRequest() {
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
	
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	@Override
	public String toString() {
		return "OrderRequest [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", customerId=" + customerId + ", productId=" + productId + "]";
	}

	
}
