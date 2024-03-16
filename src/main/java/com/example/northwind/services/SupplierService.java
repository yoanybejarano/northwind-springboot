package com.example.northwind.services;

import com.example.northwind.dto.SupplierDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplierService {

    public Page<SupplierDTO> getSupplierPage(Pageable pageable);
    public SupplierDTO findById(Long id);

}
