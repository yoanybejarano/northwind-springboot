package com.example.northwind.services;

import com.example.northwind.dto.EmployeeDTO;
import com.example.northwind.entities.EmployeesEntity;
import com.example.northwind.repositories.EmployeeRepository;
import com.example.northwind.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return employeeRepository.findAll().stream().map(this::mapToEmployeeDTO).toList();
    }

    private EmployeeDTO mapToEmployeeDTO(EmployeesEntity employeesEntity) {
        return DtoMapper.mapToEmployeeDTO(employeesEntity);
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Optional<EmployeesEntity> emp = employeeRepository.findById(id);
        return DtoMapper.mapToEmployeeDTO(emp.get());
    }

}
