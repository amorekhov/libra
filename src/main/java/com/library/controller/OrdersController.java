package com.library.controller;

import com.library.domain.Orders;
import com.library.repository.BookRepo;
import com.library.repository.OrdersRepo;
import com.library.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public String ordersView(Model model){

        model.addAttribute("orders", ordersService.ordersFindAll());
        return "/orders";
    }

    @PostMapping("/orders")
    public String orderadd() {
        return "/orders";
    }

    @GetMapping("/orders/del/{orders}")
    public String ordersDel(@PathVariable Orders orders){
        ordersService.delOrders(orders);
        return "redirect:/orders";
    }
}

