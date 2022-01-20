package com.library.LibraryApp.controller;

import com.library.LibraryApp.entity.Book;
import com.library.LibraryApp.entity.dto.BookDto;
import com.library.LibraryApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findAllById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.insert(book));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.update(book));
    }
}
