package com.example.northwind.controllers;

import com.example.northwind.dto.SupplierDTO;
import com.example.northwind.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @RequestMapping("/all")
    public ResponseEntity<Page<SupplierDTO>> getAll(@RequestParam(defaultValue = "10", required = false)
                                                    Integer pageSize,
                                                    @RequestParam(defaultValue = "0", required = false)
                                                    Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(this.supplierService.getSupplierPage(pageable));
    }

    @RequestMapping("/{id}")
    public SupplierDTO findById(@PathVariable("id") Long id) {
        return this.supplierService.findById(id);
    }

}
