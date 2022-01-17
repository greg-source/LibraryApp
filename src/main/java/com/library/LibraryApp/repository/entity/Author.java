package com.library.LibraryApp.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;
    private String firstName;
    private String lastName;
    private Timestamp bornYear;
    private Timestamp deathYear;

}
