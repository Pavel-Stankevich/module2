package com.epam.jmp.bayanouskaya.task11.controller;

import com.epam.jmp.bayanouskaya.task11.domain.Order;
import com.epam.jmp.bayanouskaya.task11.domain.OrderStatus;
import com.epam.jmp.bayanouskaya.task11.domain.User;
import com.epam.jmp.bayanouskaya.task11.service.api.GoodService;
import com.epam.jmp.bayanouskaya.task11.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class GoodController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("goods.html")
    private String goods(Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        model.addAttribute("order", orderService.getDraftOrderByUserId(user.getId()));
        model.addAttribute("goods", goodService.getGoods());
        System.out.println(orderService.getDraftOrderByUserId(user.getId()));
        return "goods";
    }

    @RequestMapping("addToCart.html")
    private String addToCart(@RequestParam("goodId") Long id, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        Order order = orderService.getDraftOrderByUserId(user.getId());
        if (null == order) {
            order = new Order();
            order.setOwner(user);
            order.setOrderStatus(OrderStatus.DRAFT);
            order.setGoods(new ArrayList<>());
            orderService.save(order);
            order = orderService.getDraftOrderByUserId(user.getId());
        }
        orderService.addGood(order, goodService.getGood(id));
        order.getGoods().add(goodService.getGood(id));
        return "redirect:/startPage.html";
    }
}
