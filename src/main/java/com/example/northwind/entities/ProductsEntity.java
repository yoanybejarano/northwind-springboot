package com.example.northwind.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products", schema = "northwind", catalog = "")
public class ProductsEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductID")
    private Long productId;
    @Basic
    @Column(name = "ProductName")
    private String productName;
    @ManyToOne
    @JoinColumn(name="SupplierID", nullable=false)
    private SuppliersEntity supplier;
    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable=false)
    private CategoriesEntity category;
    @Basic
    @Column(name = "Unit")
    private String unit;
    @Basic
    @Column(name = "Price")
    private float price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return productId == that.productId && Objects.equals(productName, that.productName) && Objects.equals(supplier, that.supplier) && Objects.equals(category, that.category) && Objects.equals(unit, that.unit) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, supplier, category, unit, price);
    }


}
