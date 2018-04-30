package com.epam.jmp.bayanouskaya.task11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("index.html")
    private String index(Model model) {
        return "index";
    }
}
