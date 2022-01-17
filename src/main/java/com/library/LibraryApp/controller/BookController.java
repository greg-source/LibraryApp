package com.library.LibraryApp.controller;

import com.library.LibraryApp.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping(path = "/books")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping(path = "/books/{id}")
    public ResponseEntity<?> findAllById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findAllById(id));
    }
}
