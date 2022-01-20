package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.LibraryRepository;
import com.library.LibraryApp.entity.Book;
import com.library.LibraryApp.entity.Library;
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
class LibraryServiceImplTest {
    @MockBean
    private LibraryRepository libraryRepository;

    @InjectMocks
    private LibraryServiceImpl libraryService;


    @Test
    void findAll() {
        List<Library> libraryList = new ArrayList();

        Library libraryOne = Library.builder().libraryId(1l).book(Book.builder().build()).build();
        Library libraryTwo = Library.builder().libraryId(1l).book(Book.builder().build()).build();
        Library libraryThree = Library.builder().libraryId(1l).book(Book.builder().build()).build();

        libraryList.add(libraryOne);
        libraryList.add(libraryTwo);
        libraryList.add(libraryThree);

        Mockito.when(libraryRepository.findAll()).thenReturn(libraryList);

        List<Library> resultList = libraryService.findAll();

        assertEquals(3, resultList.size());

    }

    @Test
    void findById() {
        Library libraryOne = Library.builder().libraryId(1l).book(Book.builder().build()).build();

        Mockito.doReturn(libraryOne).when(libraryRepository).findByLibraryId(1l);

        Library resultLibraryOne = libraryService.findById(1l);

        assertEquals(resultLibraryOne, libraryOne);

    }

    @Test
    void insert() {
        Library libraryOne = Library.builder().libraryId(1l).book(Book.builder().build()).build();

        libraryService.insert(libraryOne);

        Mockito.verify(libraryRepository, Mockito.times(1)).save(libraryOne);
    }

    @Test
    void deleteById() {
        Library libraryOne = Library.builder().libraryId(1l).book(Book.builder().build()).build();
        libraryRepository.save(libraryOne);
        libraryService.deleteById(1l);
        Mockito.verify(libraryRepository, Mockito.times(1)).deleteById(1l);

    }

    @Test
    void update() {
        Library libraryOne = Library.builder().libraryId(1l).book(Book.builder().build()).build();

        libraryService.insert(libraryOne);

        Mockito.verify(libraryRepository, Mockito.times(1)).save(libraryOne);
    }
}