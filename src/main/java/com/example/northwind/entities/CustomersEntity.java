package com.example.northwind.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customers", schema = "northwind", catalog = "")
public class CustomersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CustomerID")
    private Long customerId;
    @Basic
    @Column(name = "CustomerName")
    private String customerName;
    @Basic
    @Column(name = "ContactName")
    private String contactName;
    @Basic
    @Column(name = "Address")
    private String address;
    @Basic
    @Column(name = "City")
    private String city;
    @Basic
    @Column(name = "PostalCode")
    private String postalCode;
    @Basic
    @Column(name = "Country")
    private String country;
    @OneToMany(mappedBy="customer")
    private Set<OrdersEntity> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return customerId == that.customerId && Objects.equals(customerName, that.customerName) && Objects.equals(contactName, that.contactName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(postalCode, that.postalCode) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, contactName, address, city, postalCode, country);
    }
}
