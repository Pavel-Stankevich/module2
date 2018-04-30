package com.epam.jmp.bayanouskaya.task11.service.impl;

import com.epam.jmp.bayanouskaya.task11.domain.Order;
import com.epam.jmp.bayanouskaya.task11.repository.api.OrderRepository;
import com.epam.jmp.bayanouskaya.task11.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order getOrder(Long id) {
        return orderRepository.read(id);
    }

    @Override
    public void save(Order order) {
        if (null == order.getId()) {
            orderRepository.create(order);
        } else {
            orderRepository.update(order);
        }
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
