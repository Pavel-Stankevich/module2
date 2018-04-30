package com.epam.jmp.bayanouskaya.task11.controller;

import com.epam.jmp.bayanouskaya.task11.domain.User;
import com.epam.jmp.bayanouskaya.task11.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("index.html")
    private String index(Model model) {
        return "index";
    }

    @PostMapping("login.html")
    private String login(@ModelAttribute("user") User user, HttpSession httpSession, Model model) {
        User dbUser = userService.getUserByEmail(user.getEmail());
        if (dbUser.getPassword().equals(user.getPassword())) {
            httpSession.setAttribute("user", dbUser);
            return "redirect:/startPage.html";
        } else {
            model.addAttribute("user", user);
            return "index";
        }
    }

    @GetMapping("registration.html")
    private String registrationGet(HttpSession httpSession, Model model) {
        return "registration";
    }

    @PostMapping("registration.html")
    private String registrationPost(@ModelAttribute("user") User user, HttpSession httpSession, Model model) {
        if (null == user || user.getEmail().isEmpty() || userService.getUserByEmail(user.getEmail()) != null || user.getPassword().isEmpty()) {
            model.addAttribute("user", user);
            return "registration";
        } else {
            userService.save(user);
            user = userService.getUser(user.getId());
            httpSession.setAttribute("user", user);
            return "redirect:/startPage.html";
        }
    }

    @PostMapping("startPage.html")
    private String startPage(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        String startPage = "";
        if (null == user) {
            startPage = "index.html";
        } else if (user.getRole().getName().equals("user")) {
            startPage = "products.html";
        } else {
            startPage = "orders.html";
        }
        return String.format("redirect:/%s", startPage);
    }
}
