package com.example.northwind.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderDetailDTO {

    private Long orderDetailId;
    private Long orderId;
    private Long productId;
    private Integer quantity;

}
