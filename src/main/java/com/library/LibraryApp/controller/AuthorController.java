package com.library.LibraryApp.controller;

import com.library.LibraryApp.repository.entity.Author;
import com.library.LibraryApp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findAllById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findById(id));
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.insert(author));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.update(author));
    }
}
