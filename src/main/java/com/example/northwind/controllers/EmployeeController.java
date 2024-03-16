package com.example.northwind.controllers;

import com.example.northwind.dto.EmployeeDTO;
import com.example.northwind.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        return ResponseEntity.ok(this.employeeService.getAll());
    }

    @RequestMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") Long id) {
        return this.employeeService.findById(id);
    }


}
