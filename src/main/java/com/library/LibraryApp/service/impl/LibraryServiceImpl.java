package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.LibraryRepository;
import com.library.LibraryApp.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {
    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }
}
