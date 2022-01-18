package com.library.LibraryApp.controller;

import com.library.LibraryApp.repository.entity.Genre;
import com.library.LibraryApp.service.GenreService;
import com.library.LibraryApp.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GenreController {
    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
    @GetMapping(path = "/genres")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(genreService.findAll());
    }

    @GetMapping(path = "/genres/{id}")
    public ResponseEntity<?> findAllById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.findById(id));
    }
    @PostMapping(path = "/genres")
    public ResponseEntity<?> insert(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.insert(genre));
    }

    @DeleteMapping(path = "/genres/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        genreService.deleteById(id);
        return ResponseEntity.ok("OK");
    }
    @PutMapping(path = "/genres")
    public ResponseEntity<?> update(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.update(genre));
    }
}
