package com.epam.jmp.bayanouskaya.task11.controller;

import com.epam.jmp.bayanouskaya.task11.domain.User;
import com.epam.jmp.bayanouskaya.task11.service.api.UserService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;

@Controller
public class IndexController {

    @RequestMapping("index.html")
    private String index(Model model) {
        return "index";
    }
}
