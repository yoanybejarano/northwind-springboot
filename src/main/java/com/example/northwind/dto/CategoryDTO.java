package com.example.northwind.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
    private String description;
    private String imageUrl;
}
