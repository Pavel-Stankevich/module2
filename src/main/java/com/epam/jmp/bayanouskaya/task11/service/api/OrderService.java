package com.epam.jmp.bayanouskaya.task11.service.api;

import com.epam.jmp.bayanouskaya.task11.domain.Order;

import java.util.List;

public interface OrderService {

    Order getOrder(Long id);

    void save(Order order);

    void delete(Long id);

    List<Order> getOrders();
}
