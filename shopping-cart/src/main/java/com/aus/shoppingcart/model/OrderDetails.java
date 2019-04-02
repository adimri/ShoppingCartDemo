package com.aus.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

	@Entity
	public class OrderDetails {

	    @EmbeddedId
	    @JsonIgnore
	    private OrderDetailsPK pk;

	    @Column(nullable = false) private Integer quantity;

	    public OrderDetails() {
	        super();
	    }

	    public OrderDetails(Orders orders, Inventory inventory, Integer quantity) {
	        pk = new OrderDetailsPK();
	        pk.setOrder(orders);
	        pk.setInventory(inventory);
	        this.quantity = quantity;
	    }

	    @Transient
	    public Inventory getInventory() {
	        return this.pk.getInventory();
	    }

	    @Transient
	    public Double getTotalPrice() {
	        return getInventory().getPrice() * getQuantity();
	    }

	    public OrderDetailsPK getPk() {
	        return pk;
	    }

	    public void setPk(OrderDetailsPK pk) {
	        this.pk = pk;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        OrderDetails other = (OrderDetails) obj;
	        if (pk == null) {
	            if (other.pk != null) {
	                return false;
	            }
	        } else if (!pk.equals(other.pk)) {
	            return false;
	        }

	        return true;
	    }
	}
