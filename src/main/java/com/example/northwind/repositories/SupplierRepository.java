package com.example.northwind.repositories;

import com.example.northwind.entities.SuppliersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SuppliersEntity, Long> {
}
