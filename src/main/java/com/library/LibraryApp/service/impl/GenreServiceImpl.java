package com.library.LibraryApp.service.impl;

import com.library.LibraryApp.repository.GenreRepository;
import com.library.LibraryApp.repository.entity.Genre;
import com.library.LibraryApp.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findByGenreId(id);
    }

    @Override
    public Genre insert(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Genre update(Genre genre) {
        return genreRepository.save(genre);
    }
}
