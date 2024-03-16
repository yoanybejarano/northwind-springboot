package com.example.northwind.services;

import com.example.northwind.dto.ShipperDTO;
import com.example.northwind.entities.ShippersEntity;
import com.example.northwind.repositories.ShipperRepository;
import com.example.northwind.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShipperServiceImpl implements ShipperService{
    private final ShipperRepository shipperRepository;

    @Autowired
    public ShipperServiceImpl(ShipperRepository shipperRepository){
        this.shipperRepository = shipperRepository;
    }

    @Override
    public List<ShipperDTO> getAll() {
        return shipperRepository.findAll().stream().map(this::mapToShipperDTO).toList();
    }

    private ShipperDTO mapToShipperDTO(ShippersEntity shippersEntity) {
        return DtoMapper.mapToShipperDTO(shippersEntity);
    }

    @Override
    public ShipperDTO findById(Long id) {
        Optional<ShippersEntity> shp = shipperRepository.findById(id);
        return DtoMapper.mapToShipperDTO(shp.get());
    }


}
