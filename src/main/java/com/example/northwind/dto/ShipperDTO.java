package com.example.northwind.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ShipperDTO {

    private Long shipperId;
    private String shipperName;
    private String phone;

}
