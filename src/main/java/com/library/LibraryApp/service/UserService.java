package com.library.LibraryApp.service;

import com.library.LibraryApp.repository.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User insert(User user);

    void deleteById(Long id);

    User update(User user);
}
