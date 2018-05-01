package com.epam.jmp.bayanouskaya.task11.controller;

import com.epam.jmp.bayanouskaya.task11.domain.OrderStatus;
import com.epam.jmp.bayanouskaya.task11.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("orders.html")
    private String orders(Model model) {
        model.addAttribute("orders", orderService.getOrders());
        model.addAttribute("statuses", OrderStatus.values());
        return "orders";
    }

    @RequestMapping("editStatus.html")
    private String editStatus(@RequestParam("orderId") Long orderId, @RequestParam("status") String status, Model model) {
        orderService.updateStatus(orderId, OrderStatus.valueOf(status));
        model.addAttribute("orders", orderService.getOrders());
        model.addAttribute("statuses", OrderStatus.values());
        return "redirect:/startPage.html";
    }
}
