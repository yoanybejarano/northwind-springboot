package com.example.northwind.services;

import com.example.northwind.dto.CustomerDTO;
import com.example.northwind.dto.OrderDTO;
import com.example.northwind.entities.CustomersEntity;
import com.example.northwind.entities.OrdersEntity;
import com.example.northwind.repositories.OrderRepository;
import com.example.northwind.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public Page<OrderDTO> getOrderPage(Pageable pageable) {
        return orderRepository.findAll(pageable).map(this::mapToOrderDTO);
    }

    private OrderDTO mapToOrderDTO(OrdersEntity ordersEntity) {
        return DtoMapper.mapToOrderDTO(ordersEntity);
    }

    @Override
    public OrderDTO findById(Long id) {
        Optional<OrdersEntity> order = orderRepository.findById(id);
        return DtoMapper.mapToOrderDTO(order.get());
    }



}
