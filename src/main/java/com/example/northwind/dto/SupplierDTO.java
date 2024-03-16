package com.example.northwind.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class SupplierDTO {

    private Long supplierId;
    private String supplierName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String phone;

}
