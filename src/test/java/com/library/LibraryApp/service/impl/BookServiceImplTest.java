package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.BookRepository;
import com.library.LibraryApp.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class BookServiceImplTest {
    @MockBean
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;


    @Test
    void findAll() {
        List<Book> bookList = new ArrayList();

        Book bookOne = Book.builder().bookId(1l).title("Eneida1").link("google.com").build();
        Book bookTwo = Book.builder().bookId(2l).title("Eneida2").link("google.com").build();
        Book bookThree = Book.builder().bookId(3l).title("Eneida_forever").link("google.com").build();

        bookList.add(bookOne);
        bookList.add(bookTwo);
        bookList.add(bookThree);

        Mockito.when(bookRepository.findAll()).thenReturn(bookList);

        List<Book> resultList = bookService.findAll();

        assertEquals(3, resultList.size());

    }

    @Test
    void findById() {
        Book bookOne = Book.builder().bookId(1l).title("Eneida1").link("google.com").build();

        Mockito.doReturn(bookOne).when(bookRepository).findByBookId(1l);

        Book resultBookOne = bookService.findById(1l);

        assertEquals(resultBookOne.getTitle(), bookOne.getTitle());

    }

    @Test
    void insert() {
        Book bookOne = Book.builder().bookId(1l).title("Eneida1").link("google.com").build();

        bookService.insert(bookOne);

        Mockito.verify(bookRepository, Mockito.times(1)).save(bookOne);
    }

    @Test
    void deleteById() {
        Book bookOne = Book.builder().bookId(1l).title("Classic").build();
        bookRepository.save(bookOne);
        bookService.deleteById(1l);
        Mockito.verify(bookRepository, Mockito.times(1)).deleteById(1l);

    }

    @Test
    void update() {
        Book bookOne = Book.builder().bookId(1l).title("Classic").build();

        bookService.insert(bookOne);

        Mockito.verify(bookRepository, Mockito.times(1)).save(bookOne);
    }
}