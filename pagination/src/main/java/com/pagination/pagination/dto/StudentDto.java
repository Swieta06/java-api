package com.pagination.pagination.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentDto {

    private Long id;
    private String name;
    private int age;
    private String alamat;

}
