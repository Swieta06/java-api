package com.petsQu.Lsp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private int price;
    private String image;


}
