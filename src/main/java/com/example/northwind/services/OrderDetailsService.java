package com.example.northwind.services;

import com.example.northwind.dto.OrderDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderDetailsService {

    public Page<OrderDetailDTO> getOrderDetailPage(Pageable pageable);
    public OrderDetailDTO findById(Long id);

}
