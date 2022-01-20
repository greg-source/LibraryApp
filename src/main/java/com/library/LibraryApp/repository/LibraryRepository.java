package com.library.LibraryApp.repository;

import com.library.LibraryApp.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    @Query("SELECT b FROM Library b WHERE b.libraryId = ?1")
    Library findByLibraryId(Long id);
}
