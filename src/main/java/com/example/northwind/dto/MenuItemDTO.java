package com.example.northwind.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MenuItemDTO {
    private Long menuItemId;
    private String name;
    private String href;
    private boolean current;
}
