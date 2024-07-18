package com.wissen.kafka.OrderConsumer.deserializers;

public class Order {
	
	private String customerName; // first will act as key
	private String product; // remaining fields will act as values
	private int quantity; // value

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
