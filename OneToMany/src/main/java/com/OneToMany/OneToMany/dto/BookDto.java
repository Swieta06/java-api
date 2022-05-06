package com.OneToMany.OneToMany.dto;
import com.OneToMany.OneToMany.model.Chapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String year;
    private List<ChapterDto> ChapterDtoList;
    private Boolean isDeleted;


    public BookDto(Long id, String title, String author, String year, Boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isDeleted = isDeleted;
    }
}
