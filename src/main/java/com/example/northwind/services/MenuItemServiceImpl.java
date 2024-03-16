package com.example.northwind.services;

import com.example.northwind.dto.MenuItemDTO;
import com.example.northwind.entities.CustomersEntity;
import com.example.northwind.entities.MenuItemsEntity;
import com.example.northwind.repositories.MenuItemRepository;
import com.example.northwind.utils.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MenuItemServiceImpl implements MenuItemService{

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository){
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItemDTO> getAll() {
        return menuItemRepository.findAll().stream().map(this::mapToMenuItemDTO).toList();
    }

    private MenuItemDTO mapToMenuItemDTO(MenuItemsEntity menuItemsEntity) {
        return DtoMapper.mapToMenuItemDTO(menuItemsEntity);
    }

    @Override
    public boolean setNewCurrentMenuItem(Long menuItemId) {
        return menuItemRepository.setNewCurrentMenuItem(menuItemId);
    }

    @Override
    public MenuItemDTO setNewCurrent(Long menuItemId) {
        MenuItemsEntity newSelected = menuItemRepository.setNewCurrent(menuItemId);
        return DtoMapper.mapToMenuItemDTO(newSelected);
    }

}
