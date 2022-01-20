package com.library.LibraryApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.LibraryApp.entity.Book;
import com.library.LibraryApp.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void findAll() throws Exception {
        List<Book> bookList = new ArrayList();

        Book bookOne = Book.builder().bookId(1l).title("Eneida1").link("google.com").build();
        Book bookTwo = Book.builder().bookId(2l).title("Eneida2").link("google.com").build();
        Book bookThree = Book.builder().bookId(3l).title("Eneida_forever").link("google.com").build();

        bookList.add(bookOne);
        bookList.add(bookTwo);
        bookList.add(bookThree);

        Mockito.when(bookService.findAll()).thenReturn(bookList);

        String expectedValue = objectMapper.writeValueAsString(bookList);

        String givenValue = mockMvc.perform(get("/books")).andReturn().getResponse().getContentAsString();

        assertEquals(expectedValue, givenValue);
    }

    @Test
    void findAllById() throws Exception {
        Book bookOne = Book.builder().bookId(1l).title("Eneida1").link("google.com").build();

        Mockito.doReturn(bookOne).when(bookService).findById(1l);

        String expectedValue = objectMapper.writeValueAsString(bookOne);

        String givenValue = mockMvc.perform(get(String.format("/books/%d", bookOne.getBookId()))).andReturn().getResponse().getContentAsString();

        assertEquals(expectedValue, givenValue);
    }

    @Test
    void insert() throws Exception {
        Book bookOne = Book.builder().bookId(1l).title("Eneida1").link("google.com").build();

        String content = objectMapper.writeValueAsString(bookOne);

        mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(content));

        Mockito.verify(bookService, Mockito.times(1)).insert(bookOne);
    }

    @Test
    void delete() throws Exception {
        Book bookOne = Book.builder().bookId(1l).title("Eneida1").link("google.com").build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/books/1"));

        Mockito.verify(bookService, Mockito.times(1)).deleteById(bookOne.getBookId());
    }

    @Test
    void update() throws Exception {
        Book bookOne = Book.builder().bookId(1l).title("Eneida1").link("google.com").build();

        String content = objectMapper.writeValueAsString(bookOne);

        mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(content));

        Mockito.verify(bookService, Mockito.times(1)).insert(bookOne);
    }
}