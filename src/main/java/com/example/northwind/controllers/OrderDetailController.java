package com.example.northwind.controllers;

import com.example.northwind.dto.OrderDetailDTO;
import com.example.northwind.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailController {

    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @RequestMapping("/all")
    public ResponseEntity<Page<OrderDetailDTO>> getAll(@RequestParam(defaultValue = "10", required = false)
                                                    Integer pageSize,
                                                       @RequestParam(defaultValue = "0", required = false)
                                                    Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(this.orderDetailsService.getOrderDetailPage(pageable));
    }

    @RequestMapping("/{id}")
    public OrderDetailDTO findById(@PathVariable("id") Long id) {
        return this.orderDetailsService.findById(id);
    }
    
}
