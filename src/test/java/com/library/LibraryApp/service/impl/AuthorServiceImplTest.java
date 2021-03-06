package com.library.LibraryApp.service.impl;


import com.library.LibraryApp.repository.AuthorRepository;
import com.library.LibraryApp.entity.Author;
import com.library.LibraryApp.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {
    @Mock
    private AuthorRepository authorRepository;
    private AuthorService underTest;
    static Map<Long, Author> testAuthorMap;

    static {
        testAuthorMap = new HashMap<>();
        Author author = Author.builder().firstName("John").lastName("Watson").bornYear(LocalDate.of(1660, 1, 8)).build();
        testAuthorMap.put(author.getAuthorId(), author);
        author = Author.builder().firstName("John2").lastName("Watson2").bornYear(LocalDate.of(1660, 1, 8)).build();
        testAuthorMap.put(author.getAuthorId(), author);
        author = Author.builder().firstName("John3").lastName("Watson3").bornYear(LocalDate.of(1660, 1, 8)).build();
        testAuthorMap.put(author.getAuthorId(), author);
    }

    @BeforeEach
    void setUp() {
        underTest = new AuthorServiceImpl(authorRepository);
    }

    @Test
    void canFindAllAuthors() {
        underTest.findAll();
        Mockito.verify(authorRepository).findAll();
    }

    @Test
    void canFindAllById() {
        Integer testAuthorMapSize = testAuthorMap.size();
        for (long i = 1; i <= testAuthorMapSize; i++) {
            authorRepository.save(testAuthorMap.get(i));
            underTest.findById(i);
            Mockito.verify(authorRepository).findByAuthorId(i);
        }
    }

    @Test
    void canInsert() {
        Integer testAuthorMapSize = testAuthorMap.size();
        for (long i = 1; i <= testAuthorMapSize; i++) {
            underTest.insert(testAuthorMap.get(i));
            Mockito.verify(authorRepository).save(testAuthorMap.get(i));
        }
    }

    @Test
    void canDeleteById() {
        Integer testAuthorMapSize = testAuthorMap.size();
        for (long i = 1; i <= testAuthorMapSize; i++) {
            authorRepository.save(testAuthorMap.get(i));
            underTest.deleteById(i);
            Mockito.verify(authorRepository).deleteById(i);
        }
    }

    @Test
    void canUpdate() {
        Integer testAuthorMapSize = testAuthorMap.size();
        for (long i = 1; i <= testAuthorMapSize; i++) {
            underTest.update(testAuthorMap.get(i));
            Mockito.verify(authorRepository).save(testAuthorMap.get(i));
        }
    }
}