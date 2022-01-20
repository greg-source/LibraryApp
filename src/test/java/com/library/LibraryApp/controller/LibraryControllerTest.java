package com.library.LibraryApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.LibraryApp.entity.Book;
import com.library.LibraryApp.entity.Library;
import com.library.LibraryApp.service.LibraryService;
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

@WebMvcTest(LibraryController.class)
@AutoConfigureMockMvc
class LibraryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibraryService libraryService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void findAll() throws Exception {
        List<Library> libraryList = new ArrayList();

        Library libraryOne = Library.builder().libraryId(1l).book(Book.builder().build()).build();
        Library libraryTwo = Library.builder().libraryId(1l).book(Book.builder().build()).build();
        Library libraryThree = Library.builder().libraryId(1l).book(Book.builder().build()).build();

        libraryList.add(libraryOne);
        libraryList.add(libraryTwo);
        libraryList.add(libraryThree);

        Mockito.when(libraryService.findAll()).thenReturn(libraryList);

        String expectedValue = objectMapper.writeValueAsString(libraryList);

        String givenValue = mockMvc.perform(get("/library")).andReturn().getResponse().getContentAsString();

        assertEquals(expectedValue, givenValue);
    }

    @Test
    void findAllById() throws Exception {
        Library libraryOne = Library.builder().libraryId(1l).book(Book.builder().build()).build();

        Mockito.doReturn(libraryOne).when(libraryService).findById(1l);

        String expectedValue = objectMapper.writeValueAsString(libraryOne);

        String givenValue = mockMvc.perform(get(String.format("/library/%d", libraryOne.getLibraryId()))).andReturn().getResponse().getContentAsString();

        assertEquals(expectedValue, givenValue);
    }

    @Test
    void insert() throws Exception {
        Library libraryOne = Library.builder().libraryId(1l).book(Book.builder().build()).build();

        String content = objectMapper.writeValueAsString(libraryOne);

        mockMvc.perform(post("/library").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(content));

        Mockito.verify(libraryService, Mockito.times(1)).insert(libraryOne);
    }

    @Test
    void delete() throws Exception {
        Library libraryOne = Library.builder().libraryId(1l).book(Book.builder().build()).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/library/1"));

        Mockito.verify(libraryService, Mockito.times(1)).deleteById(libraryOne.getLibraryId());
    }

    @Test
    void update() throws Exception {
        Library libraryOne = Library.builder().libraryId(1l).book(Book.builder().build()).build();

        String content = objectMapper.writeValueAsString(libraryOne);

        mockMvc.perform(post("/library").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(content));

        Mockito.verify(libraryService, Mockito.times(1)).insert(libraryOne);
    }
}