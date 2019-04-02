package com.aus.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aus.shoppingcart.model.Inventory;

@Repository
public interface InventoryRepository  extends CrudRepository<Inventory, Long> {
}

