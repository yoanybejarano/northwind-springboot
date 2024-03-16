package com.example.northwind.services;

import com.example.northwind.dto.ShipperDTO;

import java.util.List;

public interface ShipperService {

    public List<ShipperDTO> getAll();
    public ShipperDTO findById(Long id);

}
