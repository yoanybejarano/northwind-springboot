package com.example.northwind.services;

import com.example.northwind.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    public List<CategoryDTO> getAll();
    public CategoryDTO findById(Long id);



}
