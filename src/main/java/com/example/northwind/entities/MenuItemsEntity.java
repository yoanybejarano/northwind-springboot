package com.example.northwind.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "menuitems", schema = "northwind", catalog = "")
public class MenuItemsEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MenuItemID")
    private Long menuItemId;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Href")
    private String href;
    @Basic
    @Column(name = "Current")
    private boolean current;

}
