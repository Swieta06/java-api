package com.onetoone.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookChapterGroupResponse {

    private String name;
    private List<BookChapterResponse> bookChapter;
}
