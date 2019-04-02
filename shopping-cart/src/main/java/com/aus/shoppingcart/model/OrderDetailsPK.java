package com.aus.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class OrderDetailsPK implements Serializable {

    private static final long serialVersionUID = 1L;

	@JsonBackReference
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Orders order;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Inventory inventory;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailsPK other = (OrderDetailsPK) obj;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}

}
