package com.library.LibraryApp.repository;

import com.library.LibraryApp.repository.entity.Author;
import com.library.LibraryApp.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByBookId(Long id);
}
