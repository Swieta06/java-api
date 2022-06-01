package com.onetoone.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MobilDetailDto {

    private Long id;
    private String color;
    private Boolean isNew;
    private Integer year;
    private Double price;
    private String name;
    private String spec;
}
