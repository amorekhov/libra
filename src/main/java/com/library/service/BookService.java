package com.library.service;

import com.library.domain.Book;
import com.library.domain.User;
import com.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepo bookRepo;

    public Iterable<Book> booksFindAll() {
        return bookRepo.findAll();
    }

    public Iterable<Book> booksSort(Sort sort) {
        return bookRepo.findAll(sort);
    }

    public void delBook(Book book) {
        bookRepo.delete(book);
    }

    public void saveBook(Book book) {
        bookRepo.save(book);
    }

    public void bookUpdate(Book book, String name, String author, String description) {
        book.setBookId(book.getBookId());
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        saveBook(book);
    }

    public void bookAdd(String name, String author, String description) {
        Book book = new Book(name, author, description);
        book.setAvailability(true);
        saveBook(book);
    }

    public void takeBook(Book book, User user) {
        book.setAvailability(false);
        book.setUser(user);
        saveBook(book);
    }

    public void delTakeBook(Book book) {
        book.setAvailability(true);
        book.setUser(null);
        saveBook(book);
    }

    @Autowired
    public void setBookRepo(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
}
