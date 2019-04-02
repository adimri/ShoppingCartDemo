package com.aus.shoppingcart.service.impl;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aus.shoppingcart.model.Orders;
import com.aus.shoppingcart.repository.OrderRepository;
import com.aus.shoppingcart.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Iterable<Orders> getAllOrders() {
		return this.orderRepository.findAll();
	}

	@Override
	public Orders create(Orders order) {
		order.setDateCreated(LocalDate.now());

		return this.orderRepository.save(order);
	}

	@Override
	public void update(Orders order) {
		this.orderRepository.save(order);
	}
}
