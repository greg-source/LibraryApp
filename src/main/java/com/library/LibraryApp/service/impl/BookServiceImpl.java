package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.entity.Author;
import com.library.LibraryApp.entity.Genre;
import com.library.LibraryApp.entity.dto.BookDto;
import com.library.LibraryApp.repository.AuthorRepository;
import com.library.LibraryApp.repository.BookRepository;
import com.library.LibraryApp.entity.Book;
import com.library.LibraryApp.repository.GenreRepository;
import com.library.LibraryApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private GenreRepository genreRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findByBookId(id);
    }

    @Override
    public Book insert(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book insertBookWithExistingAuthorAndGenre(BookDto bookDto) {
        return bookRepository.save(this.convertBookDtoToBookEntity(bookDto));
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

    public Book convertBookDtoToBookEntity(BookDto bookDto) {
        Long bookId = bookDto.getBookId();
        String title = bookDto.getTitle();
        LocalDate localDate = bookDto.getYear();
        Author author = authorRepository.findByAuthorId(bookDto.getAuthorId());
        Genre genre = genreRepository.findByGenreId(bookDto.getGenreId());
        String link = bookDto.getLink();
        return new Book(bookId, title, localDate, author, genre, link);
    }
}