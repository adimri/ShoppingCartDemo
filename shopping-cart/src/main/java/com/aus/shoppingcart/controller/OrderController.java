package com.aus.shoppingcart.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aus.shoppingcart.dto.OrderCart;
import com.aus.shoppingcart.dto.OrderDto;
import com.aus.shoppingcart.model.OrderDetails;
import com.aus.shoppingcart.model.Orders;
import com.aus.shoppingcart.service.InventoryService;
import com.aus.shoppingcart.service.OrderDetailsService;
import com.aus.shoppingcart.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	InventoryService inventoryService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailsService orderDetailsService;

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@GetMapping
	public @NotNull Iterable<Orders> list() {
		return this.orderService.getAllOrders();
	}

	@PostMapping(path = "/orders/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Orders> create(@RequestBody OrderCart orderCart) {
		List<OrderDto> cart = orderCart.getOrderInventory();
		validateInventory(cart);
		Orders orders = new Orders();
		orders.setStatus("PAID");
		orders = this.orderService.create(orders);
		try {
			List<OrderDetails> orderDetails = new ArrayList<>();
			for (OrderDto dto : cart) {
				orderDetails.add(orderDetailsService.create(new OrderDetails(orders,
						inventoryService.getInventory(dto.getInventory().getId()), dto.getQuantity())));
			}

			orders.setOrderDetails(orderDetails);

			this.orderService.update(orders);

		} catch (Exception e) {
			log.error("Exception while fetching data=>", e);
		}
		return new ResponseEntity<>(orders, HttpStatus.CREATED);

	}

	private void validateInventory(List<OrderDto> orderProducts) {
		try {
		orderProducts.stream()
					.filter(obj -> Objects.isNull(inventoryService.getInventory(obj.getInventory().getId())))
					.collect(Collectors.toList());
		} catch (Exception e) {
			log.error("Exception while fetching data=>", e);

		}
	}
}