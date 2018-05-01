package com.epam.jmp.bayanouskaya.task11.controller;

import com.epam.jmp.bayanouskaya.task11.domain.User;
import com.epam.jmp.bayanouskaya.task11.repository.api.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BasketController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("basket.html")
    private String registrationGet(HttpSession httpSession, Model model) {
        model.addAttribute("order", orderRepository.findOpenByUserId(((User) httpSession.getAttribute("user")).getId()));
        return "registration";
    }
}
