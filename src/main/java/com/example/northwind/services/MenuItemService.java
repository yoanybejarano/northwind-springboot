package com.example.northwind.services;

import com.example.northwind.dto.MenuItemDTO;

import java.util.List;

public interface MenuItemService {
    public List<MenuItemDTO> getAll();
    public boolean setNewCurrentMenuItem(Long menuItemId);
    public MenuItemDTO setNewCurrent(Long menuItemId);
}
