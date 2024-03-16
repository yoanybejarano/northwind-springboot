package com.example.northwind.controllers;

import com.example.northwind.dto.CustomerDTO;
import com.example.northwind.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping("/all")
    public ResponseEntity<Page<CustomerDTO>> getAll(@RequestParam(defaultValue = "10", required = false)
                                                        Integer pageSize,
                                                    @RequestParam(defaultValue = "0", required = false)
                                                        Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(this.customerService.getCustomerPage(pageable));
    }

    @RequestMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") Long id) {
        return this.customerService.findById(id);
    }

}
