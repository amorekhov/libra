package com.library.controller;

import com.library.domain.Book;
import com.library.domain.Orders;
import com.library.domain.User;
import com.library.service.BookService;
import com.library.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private OrdersService ordersService;


  @GetMapping("/book")
    public String book(Model model){
      model.addAttribute("book", bookService.booksFindAll());
      return "book";
  }

  @GetMapping("/bookadd")
    public String bookAddView() {
      return "bookadd";
  }

  @PostMapping("/bookadd")
    public String bookAdd(
            @RequestParam String name,
            @RequestParam String author,
            @RequestParam String description
  ){
      bookService.bookAdd(name,author,description);
      return "redirect:/book";
  }

    @GetMapping("/book/take/{book}")
    public String takeBookView(@PathVariable Book book, @AuthenticationPrincipal User user){
            ordersService.takeOrders(book,user);
        return "redirect:/book";
    }
    @GetMapping("/book/del/{book}")
    public String bookDel(@PathVariable Book book){
        bookService.delBook(book);
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
      bookService.bookUpdate(book,name,author,description);
      return "redirect:/book";
  }
    @GetMapping("/book/sortnameasc")
    public String sortNameAsc(Model model){
        model.addAttribute("book", bookService.booksSort(Sort.by("name").ascending()));
        return "book";
    }
    @GetMapping("/book/sortnamedesc")
    public String sortNameDesc(Model model){
        model.addAttribute("book", bookService.booksSort(Sort.by("name").descending()));
        return "book";
    }
    @GetMapping("/book/sortauthorasc")
    public String sortAuthorAsc(Model model){
        model.addAttribute("book", bookService.booksSort(Sort.by("name").ascending()));
        return "book";
    }
    @GetMapping("/book/sortauthordesc")
    public String sortAuthorDesk(Model model){
        model.addAttribute("book", bookService.booksSort(Sort.by("author").descending()));
        return "book";
    }
}
