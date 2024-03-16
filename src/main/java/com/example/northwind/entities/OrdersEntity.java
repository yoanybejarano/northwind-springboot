package com.example.northwind.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders", schema = "northwind", catalog = "")
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderID")
    private Long orderId;
    @ManyToOne
    @JoinColumn(name="CustomerID", nullable=false)
    private CustomersEntity customer;
    @ManyToOne
    @JoinColumn(name="EmployeeID", nullable=false)
    private EmployeesEntity employee;
    @Basic
    @Column(name = "OrderDate")
    private Timestamp orderDate;
    @ManyToOne
    @JoinColumn(name="ShipperID", nullable=false)
    private ShippersEntity shipper;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return orderId == that.orderId && Objects.equals(customer, that.customer) && Objects.equals(employee, that.employee) && Objects.equals(orderDate, that.orderDate) && Objects.equals(shipper, that.shipper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer, employee, orderDate, shipper);
    }
}
