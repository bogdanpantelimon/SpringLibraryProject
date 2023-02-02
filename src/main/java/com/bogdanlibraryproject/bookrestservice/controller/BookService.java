package com.bogdanlibraryproject.bookrestservice.controller;

import com.bogdanlibraryproject.bookrestservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBook(@PathVariable Integer id) { return bookRepository.findById(id).get(); }

    public List<Book> getAllBooks() { return bookRepository.findAll(); }

    public void deleteBook(@PathVariable Integer id) { bookRepository.deleteById(id); }

    public ResponseEntity<?> saveBook(Book book) { return new ResponseEntity<>(bookRepository.save(book), HttpStatus.OK); }

}
