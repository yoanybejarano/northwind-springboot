package com.example.northwind.services;

import com.example.northwind.dto.CustomerDTO;
import com.example.northwind.entities.CustomersEntity;
import com.example.northwind.repositories.CustomerRepository;
import com.example.northwind.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<CustomerDTO> getCustomerPage(Pageable pageable) {
        return customerRepository.findAll(pageable).map(this::mapToCustomerDTO);
    }

    private CustomerDTO mapToCustomerDTO(CustomersEntity customersEntity) {
        return DtoMapper.mapToCustomerDTO(customersEntity);
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<CustomersEntity> ctm = customerRepository.findById(id);
        return DtoMapper.mapToCustomerDTO(ctm.get());
    }



}
