package com.library.LibraryApp.controller;

import com.library.LibraryApp.repository.AuthorRepository;
import com.library.LibraryApp.entity.Author;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthorControllerTest {
    public static String url = "http://localhost:8080/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthorRepository repository;

    private Map<Long, Author> map;

    @BeforeAll
    public void beforeAll() {
        List.of(Author.builder()
                        .firstName("John")
                        .lastName("Howard").build())
                .forEach(auth -> {
                    Author author = repository.save(auth);
                    map.put(author.getAuthorId(), author);
                });
    }

    @Test
    void findAll() {

    }

    @Test
    void findAllById() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}