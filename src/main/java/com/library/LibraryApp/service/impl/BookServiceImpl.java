package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.BookRepository;
import com.library.LibraryApp.repository.entity.Book;
import com.library.LibraryApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findByBookId(id);
    }

    @Override
    public Book insert(Book book) {
        bookRepository.save(book);
        bookRepository.flush();
        return bookRepository.findByBookId(book.getBookId());
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book update(Book book) {
        bookRepository.save(book);
        bookRepository.flush();
        return bookRepository.getById(book.getBookId());
    }
}
