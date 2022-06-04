package com.zensar.bean;

public class CartRequest {

	private int id;
	private int customerId;
	private int productId;
	private int quantity;
	
	public CartRequest(int id, int customerId, int productId, int quantity) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public CartRequest() {
		super();
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartRequest [id=" + id + ", customerId=" + customerId + ", productId=" + productId + ", quantity="
				+ quantity + "]";
	}
	
	
}
