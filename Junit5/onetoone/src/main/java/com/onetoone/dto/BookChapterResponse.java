package com.onetoone.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookChapterResponse {
    private Long id;
    private String author;
    private String title;
    private String year;
    private String content;
    private String name;
}
