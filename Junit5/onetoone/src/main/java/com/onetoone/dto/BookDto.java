package com.onetoone.dto;

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
    private List<ChapterDto> chapterDtoList;
    private Boolean isDeleted;
}
