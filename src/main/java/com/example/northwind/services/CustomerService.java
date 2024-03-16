package com.example.northwind.services;

import com.example.northwind.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    public Page<CustomerDTO> getCustomerPage(Pageable pageable);
    public CustomerDTO findById(Long id);

}
