package com.library.controller;

import com.library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

    @GetMapping("/")
    public String libra(){
        return "libra";

    }
}
