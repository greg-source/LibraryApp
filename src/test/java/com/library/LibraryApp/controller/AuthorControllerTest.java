package com.library.LibraryApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.LibraryApp.entity.Author;
import com.library.LibraryApp.repository.AuthorRepository;
import com.library.LibraryApp.entity.Author;
import com.library.LibraryApp.service.AuthorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(AuthorController.class)
@AutoConfigureMockMvc
class AuthorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService authorService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void findAll() throws Exception {
        List<Author> authorList = new ArrayList();

        Author authorOne = Author.builder().firstName("John").lastName("Watson").bornYear(LocalDate.of(1660, 1, 8)).build();
        Author authorTwo = Author.builder().firstName("John").lastName("Watson").bornYear(LocalDate.of(1660, 1, 8)).build();
        Author authorThree = Author.builder().firstName("John").lastName("Watson").bornYear(LocalDate.of(1660, 1, 8)).build();

        authorList.add(authorOne);
        authorList.add(authorTwo);
        authorList.add(authorThree);

        Mockito.when(authorService.findAll()).thenReturn(authorList);

        String expectedValue = objectMapper.writeValueAsString(authorList);

        String givenValue = mockMvc.perform(get("/authors")).andReturn().getResponse().getContentAsString();

        assertEquals(expectedValue, givenValue);
    }

    @Test
    void findAllById() throws Exception {
        Author authorOne = Author.builder().authorId(1l).firstName("John").lastName("Watson").bornYear(LocalDate.of(1660, 1, 8)).build();

        Mockito.doReturn(authorOne).when(authorService).findById(1l);

        String expectedValue = objectMapper.writeValueAsString(authorOne);

        String givenValue = mockMvc.perform(get(String.format("/authors/%d", authorOne.getAuthorId()))).andReturn().getResponse().getContentAsString();

        assertEquals(expectedValue, givenValue);
    }

    @Test
    void insert() throws Exception {
        Author authorOne = Author.builder().firstName("John").lastName("Watson").bornYear(LocalDate.of(1660, 1, 8)).build();

        String content = objectMapper.writeValueAsString(authorOne);

        mockMvc.perform(post("/authors").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(content));

        Mockito.verify(authorService, Mockito.times(1)).insert(authorOne);
    }

    @Test
    void delete() throws Exception {
        Author authorOne = Author.builder().authorId(1l).firstName("John").lastName("Watson").bornYear(LocalDate.of(1660, 1, 8)).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/authors/1"));

        Mockito.verify(authorService, Mockito.times(1)).deleteById(authorOne.getAuthorId());
    }

    @Test
    void update() throws Exception {
        Author authorOne = Author.builder().firstName("John").lastName("Watson").bornYear(LocalDate.of(1660, 1, 8)).build();

        String content = objectMapper.writeValueAsString(authorOne);

        mockMvc.perform(post("/authors").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(content));

        Mockito.verify(authorService, Mockito.times(1)).insert(authorOne);
    }
}