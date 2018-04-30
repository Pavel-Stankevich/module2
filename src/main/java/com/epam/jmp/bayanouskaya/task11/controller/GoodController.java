package com.epam.jmp.bayanouskaya.task11.controller;

import com.epam.jmp.bayanouskaya.task11.service.api.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoodController {

    @Autowired
    private GoodService goodService;

    @RequestMapping("goods.html")
    private String goods(Model model) {
        model.addAttribute("goods", goodService.getGoods());
        return "goods";
    }
}
