package com.example.northwind.utils;

import com.example.northwind.dto.*;
import com.example.northwind.entities.*;

public class DtoMapper {

    public static CategoryDTO mapToCategoryDTO(CategoriesEntity item){
        return CategoryDTO.builder()
                .categoryId(item.getCategoryId())
                .categoryName(item.getCategoryName())
                .description(item.getDescription())
                .imageUrl(item.getImageUrl())
                .build();
    }

    public static CustomerDTO mapToCustomerDTO(CustomersEntity item){
        return CustomerDTO.builder()
                .customerId(item.getCustomerId())
                .customerName(item.getCustomerName())
                .contactName(item.getContactName())
                .address(item.getAddress())
                .city(item.getCity())
                .postalCode(item.getPostalCode())
                .country(item.getCountry())
                .build();
    }

    public static EmployeeDTO mapToEmployeeDTO(EmployeesEntity item){
        return EmployeeDTO.builder()
                .employeeId(item.getEmployeeId())
                .lastName(item.getLastName())
                .firstName(item.getFirstName())
                .birthDate(item.getBirthDate())
                .photo(item.getPhoto())
                .notes(item.getNotes())
                .build();
    }

    public static ShipperDTO mapToShipperDTO(ShippersEntity item){
        return ShipperDTO.builder()
                .shipperId(item.getShipperId())
                .shipperName(item.getShipperName())
                .phone(item.getPhone())
                .build();
    }

    public static SupplierDTO mapToSupplierDTO(SuppliersEntity item){
        return SupplierDTO.builder()
                .supplierId(item.getSupplierId())
                .supplierName(item.getSupplierName())
                .supplierId(item.getSupplierId())
                .contactName(item.getContactName())
                .address(item.getAddress())
                .city(item.getCity())
                .postalCode(item.getPostalCode())
                .country(item.getCountry())
                .phone(item.getPhone())
                .build();
    }

    public static ProductDTO mapToProductDTO(ProductsEntity item){
        return ProductDTO.builder()
                .productId(item.getProductId())
                .productName(item.getProductName())
                .supplier(mapToSupplierDTO(item.getSupplier()))
                .category(mapToCategoryDTO(item.getCategory()))
                .unit(item.getUnit())
                .price(item.getPrice())
                .build();
    }

    public static OrderDTO mapToOrderDTO(OrdersEntity item){
        return OrderDTO.builder()
                .orderId(item.getOrderId())
                .customer(mapToCustomerDTO(item.getCustomer()))
                .employee(mapToEmployeeDTO(item.getEmployee()))
                .orderDate(item.getOrderDate())
                .shipper(mapToShipperDTO(item.getShipper()))
                .build();
    }

    public static MenuItemDTO mapToMenuItemDTO(MenuItemsEntity item){
        return MenuItemDTO.builder()
                .menuItemId(item.getMenuItemId())
                .name(item.getName())
                .href(item.getHref())
                .current(item.isCurrent())
                .build();
    }

}
