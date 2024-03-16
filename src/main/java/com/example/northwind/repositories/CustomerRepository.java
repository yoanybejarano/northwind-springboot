package com.example.northwind.repositories;

import com.example.northwind.entities.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomersEntity, Long> {
}
