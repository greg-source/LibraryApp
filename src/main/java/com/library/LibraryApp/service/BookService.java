package com.library.LibraryApp.service;

import com.library.LibraryApp.repository.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll();
}
