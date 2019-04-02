package com.aus.shoppingcart.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aus.shoppingcart.model.Inventory;
import com.aus.shoppingcart.repository.InventoryRepository;
import com.aus.shoppingcart.service.InventoryService;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public Iterable<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}

	@Override
	public Inventory getInventory(Long id) {
		return inventoryRepository.findById(id).orElseThrow(() -> new NullPointerException());
	}

	@Override
	public Inventory save(Inventory product) {
		return inventoryRepository.save(product);
	}
}
