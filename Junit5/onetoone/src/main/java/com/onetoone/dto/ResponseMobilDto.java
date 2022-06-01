package com.onetoone.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponseMobilDto {

    private List<MobilDto> mobilDto;
    private Boolean success;
    private Integer totalPage;
    private Integer totalData;
}
