package com.example.northwind.services;

import com.example.northwind.dto.ProductDTO;
import com.example.northwind.entities.CustomersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

        public Page<ProductDTO> getProductPage(Pageable pageable);
        public ProductDTO findById(Long id);



}
