package com.OneToMany.OneToMany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDto {

    private Long id;
    private String name;
    private String content;
    private BookDto book;
    private Boolean isDeleted;

}
