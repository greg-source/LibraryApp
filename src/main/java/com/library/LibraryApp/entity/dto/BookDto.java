package com.library.LibraryApp.entity.dto;

import com.library.LibraryApp.entity.Author;
import com.library.LibraryApp.entity.Genre;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class BookDto {
    private Long bookId;
    private String title;
    private LocalDate year;
    private Long authorId;
    private Long genreId;
    private String link;
}
