package com.ticketmanor.model;

public class OrderItem {
	Sellable sellable;
	int quantity;
	
	public OrderItem(Sellable sellable, int quantity) {
		this.sellable = sellable;
		this.quantity = quantity;
	}
	public OrderItem(Sellable sellable) {
		this(sellable, 0);
	}
}