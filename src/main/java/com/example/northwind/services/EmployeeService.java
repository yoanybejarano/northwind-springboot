package com.example.northwind.services;

import com.example.northwind.dto.CategoryDTO;
import com.example.northwind.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeDTO> getAll();
    public EmployeeDTO findById(Long id);

}
