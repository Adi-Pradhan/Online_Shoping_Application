package com.zensar.bean;

public class CartRequest {

	private int id;
	private String customerId;
	private String productId;
	private int quantity;
	
	public CartRequest() {
		super();
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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
