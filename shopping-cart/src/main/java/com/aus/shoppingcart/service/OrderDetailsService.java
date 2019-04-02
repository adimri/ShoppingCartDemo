package com.aus.shoppingcart.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.aus.shoppingcart.model.OrderDetails;

@Validated
public interface OrderDetailsService {

    OrderDetails create(@NotNull @Valid OrderDetails orderInventory);
    
}
