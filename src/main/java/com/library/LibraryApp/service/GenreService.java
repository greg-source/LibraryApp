package com.library.LibraryApp.service;

import com.library.LibraryApp.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();

    Genre findById(Long id);

    Genre insert(Genre genre);

    void deleteById(Long id);

    Genre update(Genre genre);
}
