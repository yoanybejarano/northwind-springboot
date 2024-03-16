package com.example.northwind.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class OrderDTO {

    private Long orderId;
    private CustomerDTO customer;
    private EmployeeDTO employee;
    private Timestamp orderDate;
    private ShipperDTO shipper;

}
