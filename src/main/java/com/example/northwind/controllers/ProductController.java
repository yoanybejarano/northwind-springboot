package com.example.northwind.controllers;

import com.example.northwind.dto.ProductDTO;
import com.example.northwind.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping("/all")
    public ResponseEntity<Page<ProductDTO>> getAll(@RequestParam(defaultValue = "10", required = false)
                                                        Integer pageSize,
                                                        @RequestParam(defaultValue = "0", required = false)
                                                        Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(this.productService.getProductPage(pageable));
    }

    @RequestMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id){
        return this.productService.findById(id);
    }

}
