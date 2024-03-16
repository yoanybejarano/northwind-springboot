package com.example.northwind.services;

import com.example.northwind.dto.CategoryDTO;
import com.example.northwind.dto.CustomerDTO;
import com.example.northwind.entities.CategoriesEntity;
import com.example.northwind.repositories.CategoryRepository;
import com.example.northwind.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll().stream().map(this::mapToCategoryDTO).toList();
    }

    private CategoryDTO mapToCategoryDTO(CategoriesEntity categoriesEntity) {
        return DtoMapper.mapToCategoryDTO(categoriesEntity);
    }

    @Override
    public CategoryDTO findById(Long id) {
        Optional<CategoriesEntity> cat = categoryRepository.findById(id);
        return DtoMapper.mapToCategoryDTO(cat.get());
    }



}
