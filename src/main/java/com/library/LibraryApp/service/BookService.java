package com.library.LibraryApp.service;

import com.library.LibraryApp.repository.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Long id);

    Book insert(Book book);

    void deleteById(Long id);

    Book update(Book book);
}
