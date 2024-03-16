package com.example.northwind.services;

import com.example.northwind.dto.SupplierDTO;
import com.example.northwind.entities.SuppliersEntity;
import com.example.northwind.repositories.SupplierRepository;
import com.example.northwind.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Page<SupplierDTO> getSupplierPage(Pageable pageable) {
        return supplierRepository.findAll(pageable).map(this::mapToSupplierDTO);
    }

    private SupplierDTO mapToSupplierDTO(SuppliersEntity suppliersEntity) {
        return DtoMapper.mapToSupplierDTO(suppliersEntity);
    }

    @Override
    public SupplierDTO findById(Long id) {
        Optional<SuppliersEntity> spr = supplierRepository.findById(id);
        return DtoMapper.mapToSupplierDTO(spr.get());
    }



}
