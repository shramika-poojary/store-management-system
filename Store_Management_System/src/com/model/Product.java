package com.model;

public class Product {
	private int product_id;
	private String product_name;
	private int quantity;
	private double price;
	private String unit;
	private String category;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String product_name, int quantity, double price, String unit, String category) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.quantity = quantity;
		this.price = price;
		this.unit = unit;
		this.category = category;
	}
	
	
	public int getProduct_id() {
		return product_id;
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", quantity=" + quantity
				+ ", price=" + price + ", unit=" + unit + ", category=" + category + "]";
	}
	
	
	
	
	
}
