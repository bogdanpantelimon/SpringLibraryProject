package com.bogdanlibraryproject.bookrestservice.controller;

import com.bogdanlibraryproject.bookrestservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
