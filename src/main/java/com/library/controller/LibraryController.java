package com.library.controller;

import com.library.domain.User;
import com.library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@Controller
public class LibraryController {
    @Autowired
    private UserRepo userRepository;

    @GetMapping("/")
    public String libra(Model model){
        return "libra";

    }
}
