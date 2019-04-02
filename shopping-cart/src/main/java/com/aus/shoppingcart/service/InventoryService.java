package com.aus.shoppingcart.service;

import javax.validation.constraints.NotNull;

import com.aus.shoppingcart.model.Inventory;

public interface InventoryService {

	public @NotNull Iterable<Inventory> getAllInventory();

	public Inventory getInventory(Long id);

	public Inventory save(Inventory inventory);
}
