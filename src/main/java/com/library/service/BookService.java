package com.library.service;

import com.library.domain.Book;
import com.library.repository.BookRepo;
import com.library.repository.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;


   public Iterable<Book> booksFindAll (){
       return bookRepo.findAll();
   }

   public Iterable<Book> booksSort(Sort sort){
      return bookRepo.findAll(sort);
   }

    public void delBook(Book book) {
        bookRepo.delete(book);
    }

    public void saveBook(Book book){
        bookRepo.save(book);
    }

    public void bookUpdate(Book book, String name, String author, String description){
        book.setBookId(book.getBookId());
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        saveBook(book);
    }

    public void bookAdd(String name,String author, String description){
        Book book =new Book(name,author,description);
        saveBook(book);
    }

}
