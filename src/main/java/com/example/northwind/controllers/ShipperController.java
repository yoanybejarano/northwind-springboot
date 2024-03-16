package com.example.northwind.controllers;

import com.example.northwind.dto.ShipperDTO;
import com.example.northwind.services.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shippers")
public class ShipperController {
    private final ShipperService shipperService;

    @Autowired
    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<ShipperDTO>> getAll() {
        return ResponseEntity.ok(this.shipperService.getAll());
    }

    @RequestMapping("/{id}")
    public ShipperDTO getShipperById(@PathVariable("id") Long id) {
        return this.shipperService.findById(id);
    }
}
