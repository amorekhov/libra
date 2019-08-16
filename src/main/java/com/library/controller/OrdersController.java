package com.library.controller;

import com.library.repository.BookRepo;
import com.library.repository.UserRepo;
import com.library.service.UserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserService userService;

    @GetMapping("/orders")
    public String ordersView(){
        return "/orders";
    }

    @PostMapping("/orders")
    public String orderadd() {
        return "/orders";
    }
}
