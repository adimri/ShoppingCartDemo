package com.aus.shoppingcart.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.aus.shoppingcart.model.Orders;

@Validated
public interface OrderService {

	@NotNull
	public Iterable<Orders> getAllOrders();

	public Orders create(@NotNull @Valid Orders orders);

	public void update(@NotNull @Valid Orders orders);
}
