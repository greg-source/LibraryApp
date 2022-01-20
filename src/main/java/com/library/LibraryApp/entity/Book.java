package com.library.LibraryApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String title;
    private LocalDate year;

    @ManyToOne
    @JoinColumn(name = "author_id",
            referencedColumnName = "authorId")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id",
            referencedColumnName = "genreId")
    private Genre genre;
    private String link;

}
