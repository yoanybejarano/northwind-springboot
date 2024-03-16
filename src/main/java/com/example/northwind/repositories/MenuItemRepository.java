package com.example.northwind.repositories;

import com.example.northwind.entities.MenuItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemsEntity, Long> {

    @Procedure(procedureName = "spSetNewCurrentMenuItem")
    boolean setNewCurrentMenuItem(Long menuItemID);

    @Procedure(procedureName = "spSetNewCurrent")
    MenuItemsEntity setNewCurrent(Long menuItemID);

}
