package com.OneToMany.OneToMany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookChapterResponse {
    private String author;
    private String title;
    private String year;
    private String content;
    private String name;
}
