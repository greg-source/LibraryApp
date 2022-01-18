package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.LibraryRepository;
import com.library.LibraryApp.service.LibraryService;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }
}
