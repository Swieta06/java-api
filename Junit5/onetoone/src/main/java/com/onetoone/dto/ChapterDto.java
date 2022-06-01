package com.onetoone.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChapterDto {
    private Long id;
    private String name;
    private String content;
    private BookDto book;
    private Boolean isDeleted;
}
