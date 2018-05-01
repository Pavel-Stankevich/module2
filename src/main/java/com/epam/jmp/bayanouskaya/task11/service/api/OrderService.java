package com.epam.jmp.bayanouskaya.task11.service.api;

import com.epam.jmp.bayanouskaya.task11.domain.Good;
import com.epam.jmp.bayanouskaya.task11.domain.Order;
import com.epam.jmp.bayanouskaya.task11.domain.OrderStatus;

import java.util.List;

public interface OrderService {

    Order getOrder(Long id);

    Order getDraftOrderByUserId(Long id);

    void save(Order order);

    void delete(Long id);

    void updateStatus(Long orderId, OrderStatus orderStatus);

    List<Order> getOrders();

    void addGood(Order order, Good good);
}
