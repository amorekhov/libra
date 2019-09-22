package com.library.controller;

import com.library.domain.Role;
import com.library.domain.User;
import com.library.repository.UserRepo;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/registration")
    public String registrationView() {
        return "/registration";
    }

    @PostMapping("/registration")
    public String addUser(User user) {
        userService.addUser(user);

        return "redirect:/login";
    }


}
