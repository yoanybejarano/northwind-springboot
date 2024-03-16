package com.example.northwind.repositories;

import com.example.northwind.entities.ShippersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<ShippersEntity, Long> {
}
