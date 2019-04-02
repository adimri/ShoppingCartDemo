package com.aus.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aus.shoppingcart.model.OrderDetails;
import com.aus.shoppingcart.model.OrderDetailsPK;
@Repository
public interface OrderInventoryRepository extends CrudRepository<OrderDetails, OrderDetailsPK> {
}
