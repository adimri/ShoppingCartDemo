package com.aus.shoppingcart.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.aus.shoppingcart.model.Inventory;
import com.aus.shoppingcart.repository.InventoryRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private InventoryRepository inventoryRepository;

    @Autowired
    public DataLoader(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void run(ApplicationArguments args) {
    	inventoryRepository.save(new Inventory(1L, "Carrot", 2.0));
    	inventoryRepository.save(new Inventory(1L, "Carrot", 2.00));
    	inventoryRepository.save(new Inventory(2L, "Potato", 5.00));
    	inventoryRepository.save(new Inventory(3L, "Tomato", 2.00));
    	inventoryRepository.save(new Inventory(4L, "Icecream", 5.00));
    	inventoryRepository.save(new Inventory(5L, "Peas", 3.00));
    	inventoryRepository.save(new Inventory(6L, "Mexican Beans", 2.00));
    	inventoryRepository.save(new Inventory(7L, "Capsicum", 30.00));
    }
}