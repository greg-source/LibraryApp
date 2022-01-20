package com.library.LibraryApp.repository;

import com.library.LibraryApp.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("SELECT b FROM Genre b WHERE b.genreId = ?1")
    Genre findByGenreId(Long id);
}
