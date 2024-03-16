package com.example.northwind.services;

import com.example.northwind.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    public Page<OrderDTO> getOrderPage(Pageable pageable);
    public OrderDTO findById(Long id);

}
