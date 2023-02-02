package com.bogdanlibraryproject.bookrestservice.controller;

import com.bogdanlibraryproject.bookrestservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/lib", produces = "application/json")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        try {
            Book book = bookService.getBook(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> books = bookService.getAllBooks();
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create/book")
    public ResponseEntity<?> createBook(Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.OK);
    }

/*    @PutMapping("/updateBook/{id}")
    public Book updateBook(@RequestBody Book newBook, @PathVariable Integer id) {
        return bookRepository.findById(id).
                map(book -> {
                    book.setBookName(newBook.getBookName());
                    book.setBookPrice(newBook.getBookPrice());
                    book.setBookAuthor(newBook.getBookAuthor());
                    return bookRepository.save(book);
                })
                .orElseGet( () -> {
                    newBook.setId(id);
                    return bookRepository.save(newBook);
                });
    }*/

    @DeleteMapping("delete/book/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }
}
