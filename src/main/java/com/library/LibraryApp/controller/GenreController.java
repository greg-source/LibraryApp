package com.library.LibraryApp.controller;

import com.library.LibraryApp.repository.entity.Genre;
import com.library.LibraryApp.service.GenreService;
import com.library.LibraryApp.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/genres")
public class GenreController {
    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(genreService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findAllById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.findById(id));
    }
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.insert(genre));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        genreService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Genre genre) {
        return ResponseEntity.ok(genreService.update(genre));
    }
}
