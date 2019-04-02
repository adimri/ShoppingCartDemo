package com.aus.shoppingcart.dto;

import java.util.List;

public class OrderCart {

	 private List<OrderDto> orderInventory;

	public List<OrderDto> getOrderInventory() {
		return orderInventory;
	}

	public void setOrderInventory(List<OrderDto> orderInventory) {
		this.orderInventory = orderInventory;
	}

     
}
