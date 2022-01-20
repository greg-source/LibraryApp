package com.library.LibraryApp.service;

import com.library.LibraryApp.entity.Book;
import com.library.LibraryApp.entity.dto.BookDto;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Long id);

    Book insert(Book book);

    void deleteById(Long id);

    Book update(Book book);

    Book insertBookWithExistingAuthorAndGenre(BookDto bookDto);
}
