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
@Table(name = "suppliers", schema = "northwind", catalog = "")
public class SuppliersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SupplierID")
    private Long supplierId;
    @Basic
    @Column(name = "SupplierName")
    private String supplierName;
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
    @Basic
    @Column(name = "Phone")
    private String phone;
    @OneToMany(mappedBy="supplier")
    private Set<ProductsEntity> products;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuppliersEntity that = (SuppliersEntity) o;
        return supplierId == that.supplierId && Objects.equals(supplierName, that.supplierName) && Objects.equals(contactName, that.contactName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(postalCode, that.postalCode) && Objects.equals(country, that.country) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, supplierName, contactName, address, city, postalCode, country, phone);
    }
}
