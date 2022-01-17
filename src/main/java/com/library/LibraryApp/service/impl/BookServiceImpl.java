package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.BookRepository;
import com.library.LibraryApp.repository.entity.Book;
import com.library.LibraryApp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}
