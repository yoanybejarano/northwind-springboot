package com.example.northwind.controllers;

import com.example.northwind.dto.MenuItemDTO;
import com.example.northwind.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/menuitems")
public class MenuItemController {
    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<MenuItemDTO>> getAll() {
        return ResponseEntity.ok(this.menuItemService.getAll());
    }

    @RequestMapping(value = "/newcurrent/{id}", method = RequestMethod.POST)
    public ResponseEntity<MenuItemDTO> setNewCurrent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.menuItemService.setNewCurrent(id));
    }
}
