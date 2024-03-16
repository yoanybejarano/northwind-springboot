package com.example.northwind.dto;


import lombok.*;

@Getter
@Setter
@Builder
public class CustomerDTO {

    private Long customerId;
    private String customerName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;

}
