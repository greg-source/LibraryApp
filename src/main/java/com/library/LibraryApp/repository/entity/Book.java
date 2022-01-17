package com.library.LibraryApp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private Timestamp year;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id",
            referencedColumnName = "authorId")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id",
            referencedColumnName = "genreId")
    private Genre genre;

}
