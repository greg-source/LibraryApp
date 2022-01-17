package com.library.LibraryApp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long libraryId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id",
            referencedColumnName = "bookId")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",
            referencedColumnName = "userId")
    private User user;

    @Column(columnDefinition = "int default 0")
    private Integer lastPage;
}
