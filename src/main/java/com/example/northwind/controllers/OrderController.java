package com.example.northwind.controllers;

import com.example.northwind.dto.OrderDTO;
import com.example.northwind.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/all")
    public ResponseEntity<Page<OrderDTO>> getAll(@RequestParam(defaultValue = "10", required = false)
                                                    Integer pageSize,
                                                    @RequestParam(defaultValue = "0", required = false)
                                                    Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(this.orderService.getOrderPage(pageable));
    }

    @RequestMapping("/{id}")
    public OrderDTO findById(@PathVariable("id") Long id) {
        return this.orderService.findById(id);
    }
    
}
