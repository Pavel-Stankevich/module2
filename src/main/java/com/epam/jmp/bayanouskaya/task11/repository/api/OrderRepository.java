package com.epam.jmp.bayanouskaya.task11.repository.api;

import com.epam.jmp.bayanouskaya.task11.domain.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();
}