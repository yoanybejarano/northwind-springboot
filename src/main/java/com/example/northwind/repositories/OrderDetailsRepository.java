package com.example.northwind.repositories;

import com.example.northwind.entities.OrderdetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderdetailsEntity, Long> {
}
