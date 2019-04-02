package com.aus.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aus.shoppingcart.model.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
}