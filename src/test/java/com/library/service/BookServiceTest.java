package com.library.service;

import com.library.repository.BookRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepo bookRepo;

    @Test
    public void booksFindAll() {
    }

    @Test
    public void booksSort() {
    }

    @Test
    public void delBook() {
    }

    @Test
    public void saveBook() {
    }

    @Test
    public void bookUpdate() {
    }

    @Test
    public void bookAdd() {
    }
}