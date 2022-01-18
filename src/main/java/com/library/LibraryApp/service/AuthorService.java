package com.library.LibraryApp.service;

import com.library.LibraryApp.repository.entity.Author;
import com.library.LibraryApp.repository.entity.Book;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findAllById(Long id);

    Author insert(Author author);

    void deleteById(Long id);

    Author update(Author author);
}
