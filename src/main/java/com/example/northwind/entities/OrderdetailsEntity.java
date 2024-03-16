package com.example.northwind.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orderdetails", schema = "northwind", catalog = "")
public class OrderdetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderDetailID")
    private Long orderDetailId;
    @Basic
    @Column(name = "OrderID")
    private Long orderId;
    @Basic
    @Column(name = "ProductID")
    private Long productId;
    @Basic
    @Column(name = "Quantity")
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderdetailsEntity that = (OrderdetailsEntity) o;
        return orderDetailId == that.orderDetailId && Objects.equals(orderId, that.orderId) && Objects.equals(productId, that.productId) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailId, orderId, productId, quantity);
    }
}
