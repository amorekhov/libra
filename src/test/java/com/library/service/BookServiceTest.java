package com.library.service;

import com.library.domain.Book;
import com.library.domain.Orders;
import com.library.domain.User;
import com.library.repository.BookRepo;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepo bookRepo;

    public final List<Book> books = new ArrayList<>();
    public final List<User> users = new ArrayList<>();
    public final List<Orders> orders = new ArrayList<>();

    @Before
    public void db(){
        Book book=new Book();
        book.setName("name");
        book.setAuthor("author");
        book.setDescription("description");
        books.add(book);

        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        users.add(user);

        Orders order = new Orders();
        order.setUser(user);
        order.setBook(book);
        orders.add(order);
    }

    @Test
    public void booksFindAll() {
        bookService.booksFindAll();
        Mockito.verify(bookRepo, Mockito.times(1)).findAll();
    }

    @Test
    public void booksSort() {
        bookService.booksSort(Sort.by("name").ascending());
        Mockito.verify(bookRepo, Mockito.times(1)).findAll(Sort.by("name").ascending());
    }

    @Test
    public void delBook() {
        Book book = new Book();
        bookService.delBook(book);
        Mockito.verify(bookRepo, Mockito.times(1)).delete(book);
    }

    @Test
    public void saveBook() {
        Book book = new Book();
        bookService.saveBook(book);
        Mockito.verify(bookRepo, Mockito.times(1)).save(book);

    }

    @Test
    public void bookUpdate() {
        Book book = new Book();
        String name=books.get(0).getName();
        String author=books.get(0).getAuthor();
        String description=books.get(0).getDescription();

        bookService.bookUpdate(book,name,author,description);

        Assert.assertEquals(book.getName(), books.get(0).getName());
        Assert.assertEquals(book.getAuthor(), books.get(0).getAuthor());
        Assert.assertEquals(book.getDescription(), books.get(0).getDescription());
        Mockito.verify(bookRepo, Mockito.times(1)).save(book);


    }

    @Test
    public void bookAdd() {
        Book book = new Book();
        String name=books.get(0).getName();
        String author=books.get(0).getAuthor();
        String description=books.get(0).getDescription();
        bookService.bookAdd(name,author,description);

        Mockito.verify(bookRepo, Mockito.times(1)).save(ArgumentMatchers.any(Book.class));
    }
}