package com.library.LibraryApp.controller;

import com.library.LibraryApp.repository.entity.Author;
import com.library.LibraryApp.repository.entity.Book;
import com.library.LibraryApp.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping(path = "/authors")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping(path = "/authors/{id}")
    public ResponseEntity<?> findAllById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findAllById(id));
    }
    @PostMapping(path = "/authors")
    public ResponseEntity<?> insert(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.insert(author));
    }
    @DeleteMapping(path = "/authors/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok("OK");
    }
    @PutMapping(path = "/authors")
    public ResponseEntity<?> update(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.update(author));
    }
}
