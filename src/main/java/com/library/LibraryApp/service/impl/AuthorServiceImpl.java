package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
