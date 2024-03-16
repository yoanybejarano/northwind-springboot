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
@Table(name = "shippers", schema = "northwind", catalog = "")
public class ShippersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ShipperID")
    private Long shipperId;
    @Basic
    @Column(name = "ShipperName")
    private String shipperName;
    @Basic
    @Column(name = "Phone")
    private String phone;
    @OneToMany(mappedBy="shipper")
    private Set<OrdersEntity> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippersEntity that = (ShippersEntity) o;
        return shipperId == that.shipperId && Objects.equals(shipperName, that.shipperName) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipperId, shipperName, phone);
    }
}
