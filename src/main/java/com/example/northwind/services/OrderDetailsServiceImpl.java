package com.example.northwind.services;

import com.example.northwind.dto.OrderDetailDTO;
import com.example.northwind.entities.OrderdetailsEntity;
import com.example.northwind.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService{

    private final OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository){
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public Page<OrderDetailDTO> getOrderDetailPage(Pageable pageable) {
        return orderDetailsRepository.findAll(pageable).map(this::mapToOrderDetailDTO);
    }

    @Override
    public OrderDetailDTO findById(Long id) {
        Optional<OrderdetailsEntity> order = orderDetailsRepository.findById(id);
        return mapToOrderDetailDTO(order.get());
    }

    private OrderDetailDTO mapToOrderDetailDTO(OrderdetailsEntity order){
        return OrderDetailDTO.builder()
                .orderDetailId(order.getOrderDetailId())
                .orderId(order.getOrderId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .build();
    }

}
