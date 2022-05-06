package com.OneToMany.OneToMany.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    /*1. id (Long)
2. title (String)
3. author (string)
4. year (timeStamp)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private String year;
    //buat connect model dari parent(mapped by child)
    @OneToMany(mappedBy = "book",cascade = CascadeType.PERSIST)
    private List<Chapter>ChapterList;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Book(Long id, String title, String author, String year, Boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isDeleted = isDeleted;
    }
}
