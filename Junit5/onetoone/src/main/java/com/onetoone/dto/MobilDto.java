package com.onetoone.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MobilDto {
    private Long id;

    private String brand;

    private Boolean isDeleted;

    private MobilDetailDto mobilDetailDto;
}
