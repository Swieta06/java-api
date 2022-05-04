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
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private LocalDate year;
    private List<ChapterDto> ChapterDtoList;
    private Boolean isDeleted;


}
