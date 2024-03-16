package com.example.northwind.services;

import com.example.northwind.dto.ProductDTO;
import com.example.northwind.entities.ProductsEntity;
import com.example.northwind.repositories.ProductRepository;
import com.example.northwind.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Page<ProductDTO> getProductPage(Pageable pageable) {
        return productRepository.findAll(pageable).map(this::mapToProductDTO);
    }

    private ProductDTO mapToProductDTO(ProductsEntity productsEntity) {
        return DtoMapper.mapToProductDTO(productsEntity);
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional<ProductsEntity> result = productRepository.findById(id);
        return DtoMapper.mapToProductDTO(result.get());
    }



}
