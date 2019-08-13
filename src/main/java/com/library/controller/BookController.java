package com.library.controller;

import com.library.domain.Book;
import com.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
    @Autowired
    private BookRepo bookRepo;

  @GetMapping("/book")
    public String book(Model model){

      Iterable<Book> book = bookRepo.findAll();

      model.addAttribute("book", book);


      return "book";
  }

  @GetMapping("/bookadd")
    public String bookAddView(){
      return "bookadd";
  }

  @PostMapping("/bookadd")
    public String bookAdd(
            @RequestParam String name,
            @RequestParam String author,
            @RequestParam String description,
            Model model
  ){


      Book book =new Book(name,author,description);

      book.setAvailability(true);

      bookRepo.save(book);

      return "redirect:/book";
  }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Book> getAllUsers() {
        // This returns a JSON or XML with the users
        return bookRepo.findAll();
    }
}
