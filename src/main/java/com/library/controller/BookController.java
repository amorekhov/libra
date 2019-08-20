package com.library.controller;

import com.library.domain.Book;
import com.library.domain.Orders;
import com.library.domain.User;
import com.library.repository.BookRepo;
import com.library.repository.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private OrdersRepo ordersRepo;


  @GetMapping("/book")
    public String book(Model model, Book book){

      Iterable<Book> books = bookRepo.findAll();


      model.addAttribute("book", books);




      return "book";
  }

  @GetMapping("/bookadd")
    public String bookAddView() {
      Book book = new Book();

      return "bookadd";
  }

  @PostMapping("/bookadd")
    public String bookAdd(
            @RequestParam String name,
            @RequestParam String author,
            @RequestParam String description,
           // @RequestParam Integer countAll,
            Model model
  ){


      Book book =new Book(name,author,description);

    //  book.setAvailability(true);

      bookRepo.save(book);

      return "redirect:/book";
  }

    @GetMapping("/book/take/{book}")
    public String takeBookView(@PathVariable Book book, @AuthenticationPrincipal User user, Model model){

        Orders orders = new Orders();
        orders.setBook(book);
        orders.setUser(user);
        ordersRepo.save(orders);


        return "redirect:/book";
    }

    @GetMapping("/book/del/{book}")
    public String bookDel(@PathVariable Book book){
        bookRepo.delete(book);
        return "redirect:/book";
    }



  @GetMapping("/book/edit/{book}")
  public String bookEditView(
          @PathVariable Book book,
          Model model
  ){
      model.addAttribute("id", book.getBookId());
      model.addAttribute("name", book.getName());
      model.addAttribute("author", book.getAuthor());
      model.addAttribute("description", book.getDescription());
      return "bookedit";
  }

  @PostMapping("/book/edit/{book}")
    public String editBook(
            @RequestParam String name,
            @RequestParam String author,
            @RequestParam String description,
            @PathVariable Book book

  ){
     // Optional<Book> books = bookRepo.findById(book.getBookId());
      book.setBookId(book.getBookId());
      book.setName(name);
      book.setAuthor(author);
      book.setDescription(description);

      bookRepo.save(book);


      return "redirect:/book";
  }

    @GetMapping("/book/sortnameasc")
    public String sortNameAsc(Model model){
        Iterable<Book> books = bookRepo.findAll(Sort.by("name").ascending());



        model.addAttribute("book", books);


        return "book";
    }
    @GetMapping("/book/sortnamedesc")
    public String sortNameDesc(Model model){
        Iterable<Book> books = bookRepo.findAll(Sort.by("name").descending());



        model.addAttribute("book", books);


        return "book";
    }
    @GetMapping("/book/sortauthorasc")
    public String sortAuthorAsc(Model model){
        Iterable<Book> books = bookRepo.findAll(Sort.by("author").ascending());



        model.addAttribute("book", books);


        return "book";
    }
    @GetMapping("/book/sortauthordesc")
    public String sortAuthorDesk(Model model){
        Iterable<Book> books = bookRepo.findAll(Sort.by("author").descending());



        model.addAttribute("book", books);


        return "book";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    List<Book> getAllUsers() {
        // This returns a JSON or XML with the users
        return bookRepo.findAll(Sort.by("name").descending());
    }

}
