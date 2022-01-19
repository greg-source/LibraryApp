package com.library.LibraryApp.service;

import com.library.LibraryApp.repository.entity.Library;

import java.util.List;

public interface LibraryService {
    List<Library> findAll();

    Library findById(Long id);

    Library insert(Library library);

    void deleteById(Long id);

    Library update(Library library);
}
