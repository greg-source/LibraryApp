package com.library.LibraryApp.controller;

import com.library.LibraryApp.repository.entity.Book;
import com.library.LibraryApp.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(bookService.findById(id));
    }
    @PostMapping(path = "/books")
    public ResponseEntity<?> insert(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.insert(book));
    }

    @DeleteMapping(path = "/books/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok("OK");
    }
    @PutMapping(path = "/books")
    public ResponseEntity<?> update(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.update(book));
    }
}
