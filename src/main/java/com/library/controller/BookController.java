package com.library.controller;

import com.library.domain.Book;
import com.library.domain.User;
import com.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TransferQueue;

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

  @GetMapping("/book/take/{book}")
  public String take(
          @PathVariable Book book,
          Model model
  ){
      model.addAttribute("name", book.getName());
      model.addAttribute("author", book.getAuthor());
      model.addAttribute("description", book.getDescription());
      return "redirect:/bookedit";
  }

  @PostMapping("/book/take/{book}")
    public String takeBook(
            Model model,
            Book book,
            User user
  ){
      return "redirect:/book";
  }



}
