package com.library.LibraryApp.controller;

import com.library.LibraryApp.repository.entity.Library;
import com.library.LibraryApp.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library")
public class LibraryController {
    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(libraryService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findAllById(@PathVariable Long id) {
        return ResponseEntity.ok(libraryService.findById(id));
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Library library) {
        return ResponseEntity.ok(libraryService.insert(library));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        libraryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Library library) {
        return ResponseEntity.ok(libraryService.update(library));
    }
}
