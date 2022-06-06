package com.zensar.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private double price;
	private String color;
	private String dimensions;
	private String specification;
	private String manufacturer;
	private int quantity;
	private String categoryId;
	
	

	

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Products(String productName, double price, String color, String dimensions, String specification,
			String manufacturer, int quantity, String categoryId) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimensions = dimensions;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.categoryId = categoryId;
	}
	public Products() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	
	
	
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", price=" + price + ", color="
				+ color + ", dimensions=" + dimensions + ", specification=" + specification + ", manufacturer="
				+ manufacturer + ", quantity=" + quantity + ", categoryId=" + categoryId + "]";
	}
	
	

}
