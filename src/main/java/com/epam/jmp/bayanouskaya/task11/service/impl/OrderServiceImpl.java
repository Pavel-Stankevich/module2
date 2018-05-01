package com.epam.jmp.bayanouskaya.task11.service.impl;

import com.epam.jmp.bayanouskaya.task11.domain.Good;
import com.epam.jmp.bayanouskaya.task11.domain.Order;
import com.epam.jmp.bayanouskaya.task11.repository.api.GoodRepository;
import com.epam.jmp.bayanouskaya.task11.domain.OrderStatus;
import com.epam.jmp.bayanouskaya.task11.repository.api.OrderRepository;
import com.epam.jmp.bayanouskaya.task11.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GoodRepository goodRepository;

    @Override
    public Order getOrder(Long id) {
        return orderRepository.read(id);
    }

    @Override
    public Order getDraftOrderByUserId(Long id) {
        return orderRepository.findDraftByUserId(id);
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
    public void updateStatus(final Long orderId, final OrderStatus orderStatus) {
        orderRepository.updateStatus(orderId, orderStatus);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void addGood(Order order, Good good) {
        orderRepository.addGood(order, good);
        good = goodRepository.read(good.getId());
        good.setCount(good.getCount() - 1);
        goodRepository.update(good);
    }
}
