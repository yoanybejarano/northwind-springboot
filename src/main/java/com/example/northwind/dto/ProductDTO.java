package com.example.northwind.dto;


import lombok.*;


@Getter
@Setter
@Builder
public class ProductDTO {
    private Long productId;
    private String productName;
    private SupplierDTO supplier;
    private CategoryDTO category;
    private String unit;
    private float price;
}
