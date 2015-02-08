package com.ticketmanor.model;

public class OrderItem {
	private Sellable sellable;
	private int quantity;
	
	public OrderItem(Sellable sellable, int quantity) {
		this.setSellable(sellable);
		this.setQuantity(quantity);
	}
	/** Note default quantity is 1; you don't add 0-item entries... */
	public OrderItem(Sellable sellable) {
		this(sellable, 1);
	}
	public Sellable getSellable() {
		return sellable;
	}
	public void setSellable(Sellable sellable) {
		this.sellable = sellable;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}