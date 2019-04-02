package com.aus.shoppingcart.controller;


import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aus.shoppingcart.model.Inventory;
import com.aus.shoppingcart.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	    @Autowired
	    private InventoryService inventoryService;

	    @GetMapping(value = { "", "/" })
	    public @NotNull Iterable<Inventory> getAllInventory() {
	        return inventoryService.getAllInventory();
	    }
	}
