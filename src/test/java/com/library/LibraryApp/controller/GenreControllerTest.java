package com.library.LibraryApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.LibraryApp.entity.Genre;
import com.library.LibraryApp.service.GenreService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(GenreController.class)
@AutoConfigureMockMvc
class GenreControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GenreService genreService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void findAll() throws Exception {
        List<Genre> genreList = new ArrayList();

        Genre genreOne = Genre.builder().genreId(1l).title("Classic").build();
        Genre genreTwo = Genre.builder().genreId(2l).title("Classic").build();
        Genre genreThree = Genre.builder().genreId(3l).title("Classic").build();

        genreList.add(genreOne);
        genreList.add(genreTwo);
        genreList.add(genreThree);

        Mockito.when(genreService.findAll()).thenReturn(genreList);

        String expectedValue = objectMapper.writeValueAsString(genreList);

        String givenValue = mockMvc.perform(get("/genres")).andReturn().getResponse().getContentAsString();

        assertEquals(expectedValue, givenValue);
    }

    @Test
    void findAllById() throws Exception {
        Genre genreOne = new Genre(1l, "Classic");

        Mockito.doReturn(genreOne).when(genreService).findById(1l);

        String expectedValue = objectMapper.writeValueAsString(genreOne);

        String givenValue = mockMvc.perform(get(String.format("/genres/%d", genreOne.getGenreId()))).andReturn().getResponse().getContentAsString();

        assertEquals(expectedValue, givenValue);
    }

    @Test
    void insert() throws Exception {
        Genre genreOne = Genre.builder().genreId(1l).title("Classic").build();

        String content = objectMapper.writeValueAsString(genreOne);

        mockMvc.perform(post("/genres").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(content));

        Mockito.verify(genreService, Mockito.times(1)).insert(genreOne);
    }

    @Test
    void delete() throws Exception {
        Genre genreOne = Genre.builder().genreId(1l).title("Classic").build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/genres/1"));

        Mockito.verify(genreService, Mockito.times(1)).deleteById(genreOne.getGenreId());
    }

    @Test
    void update() throws Exception {
        Genre genreOne = Genre.builder().genreId(1l).title("Classic").build();

        String content = objectMapper.writeValueAsString(genreOne);

        mockMvc.perform(post("/genres").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(content));

        Mockito.verify(genreService, Mockito.times(1)).insert(genreOne);
    }
}