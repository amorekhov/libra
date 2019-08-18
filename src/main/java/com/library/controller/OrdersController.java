package com.library.controller;

import com.library.domain.Book;
import com.library.domain.Orders;
import com.library.repository.BookRepo;
import com.library.repository.OrdersRepo;
import com.library.repository.UserRepo;
import com.library.service.UserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersController {
    @Autowired
    private OrdersRepo ordersRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserService userService;

    @GetMapping("/orders")
    public String ordersView(Model model){

        Iterable<Orders> orders = ordersRepo.findAll();

        model.addAttribute("orders", orders);
        return "/orders";
    }

    @PostMapping("/orders")
    public String orderadd() {
        return "/orders";
    }
}
