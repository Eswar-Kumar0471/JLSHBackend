package com.jayalakshmitents.bookingapp.controller;

import com.jayalakshmitents.bookingapp.model.InventoryItem;
import com.jayalakshmitents.bookingapp.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class InventoryItemController {

    @Autowired
    private InventoryItemService service;

    @GetMapping
    public List<InventoryItem> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<InventoryItem> getItem(@PathVariable Long id) {
        return service.getItemById(id);
    }

    @PostMapping
    public InventoryItem createItem(@RequestBody InventoryItem item) {
        return service.addItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
    }
}
