package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.LibraryRepository;
import com.library.LibraryApp.repository.entity.Library;
import com.library.LibraryApp.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {
    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }


    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Library findById(Long id) {
        return libraryRepository.findByLibraryId(id);
    }

    @Override
    public Library insert(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public void deleteById(Long id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public Library update(Library library) {
        return libraryRepository.save(library);
    }
}
