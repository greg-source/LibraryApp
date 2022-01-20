package com.library.LibraryApp.service;

import com.library.LibraryApp.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(Long id);

    Author insert(Author author);

    void deleteById(Long id);

    Author update(Author author);
}
