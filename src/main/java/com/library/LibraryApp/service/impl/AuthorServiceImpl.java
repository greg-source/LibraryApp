package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.AuthorRepository;
import com.library.LibraryApp.repository.entity.Author;
import com.library.LibraryApp.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAllById(Long id) {
        return authorRepository.findAllByAuthorId(id);
    }

    @Override
    public Author insert(Author author) {
        return authorRepository.save(author);
    }
}
