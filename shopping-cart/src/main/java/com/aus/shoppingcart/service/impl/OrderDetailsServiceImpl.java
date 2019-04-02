package com.aus.shoppingcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aus.shoppingcart.model.OrderDetails;
import com.aus.shoppingcart.repository.OrderInventoryRepository;
import com.aus.shoppingcart.service.OrderDetailsService;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	private OrderInventoryRepository orderInventoryRepository;

	@Override
	public OrderDetails create(OrderDetails orderDetails) {
		return this.orderInventoryRepository.save(orderDetails);
	}
}
