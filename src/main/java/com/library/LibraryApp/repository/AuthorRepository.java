package com.library.LibraryApp.repository;

import com.library.LibraryApp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT b FROM Author b WHERE b.authorId = ?1")
    Author findByAuthorId(Long id);
}
