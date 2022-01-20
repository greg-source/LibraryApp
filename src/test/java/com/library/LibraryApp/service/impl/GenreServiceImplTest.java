package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.GenreRepository;
import com.library.LibraryApp.entity.Genre;
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
class GenreServiceImplTest {
    @MockBean
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreServiceImpl genreService;


    @Test
    void findAll() {
        List<Genre> genreList = new ArrayList();

        Genre genreOne = Genre.builder().genreId(1l).title("Classic").build();
        Genre genreTwo = Genre.builder().genreId(2l).title("Classic").build();
        Genre genreThree = Genre.builder().genreId(3l).title("Classic").build();

        genreList.add(genreOne);
        genreList.add(genreTwo);
        genreList.add(genreThree);

        Mockito.when(genreRepository.findAll()).thenReturn(genreList);

        List<Genre> resultList = genreService.findAll();

        assertEquals(3, resultList.size());

    }

    @Test
    void findById() {
        Genre genreOne = new Genre(1l, "Classic");

        Mockito.doReturn(genreOne).when(genreRepository).findByGenreId(1l);

        Genre resultGenreOne = genreService.findById(1l);

        assertEquals(resultGenreOne.getTitle(), "Classic");

    }

    @Test
    void insert() {
        Genre genreOne = Genre.builder().genreId(1l).title("Classic").build();

        genreService.insert(genreOne);

        Mockito.verify(genreRepository, Mockito.times(1)).save(genreOne);
    }

    @Test
    void deleteById() {
        Genre genreOne = Genre.builder().genreId(1l).title("Classic").build();
        genreRepository.save(genreOne);
        genreService.deleteById(1l);
        Mockito.verify(genreRepository, Mockito.times(1)).deleteById(1l);

    }

    @Test
    void update() {
        Genre genreOne = Genre.builder().genreId(1l).title("Classic").build();

        genreService.insert(genreOne);

        Mockito.verify(genreRepository, Mockito.times(1)).save(genreOne);
    }
}