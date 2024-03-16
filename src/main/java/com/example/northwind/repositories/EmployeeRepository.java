package com.example.northwind.repositories;

import com.example.northwind.entities.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeesEntity, Long> {
}
