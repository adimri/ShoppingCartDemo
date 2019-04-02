package com.aus.shoppingcart.dto;

import com.aus.shoppingcart.model.Inventory;

public class OrderDto {
	private Inventory inventory;
	private int quantity;

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
