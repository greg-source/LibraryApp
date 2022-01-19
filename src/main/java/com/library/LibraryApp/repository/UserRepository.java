package com.library.LibraryApp.repository;

import com.library.LibraryApp.repository.entity.Author;
import com.library.LibraryApp.repository.entity.User;
import com.library.LibraryApp.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT b FROM User b WHERE b.userId = ?1")
    User findByUserId(Long id);
}
