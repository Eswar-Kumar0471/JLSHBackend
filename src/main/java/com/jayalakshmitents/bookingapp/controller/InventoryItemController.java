package com.jayalakshmitents.bookingapp.controller;

import com.jayalakshmitents.bookingapp.model.InventoryItem;
import com.jayalakshmitents.bookingapp.service.InventoryItemService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class InventoryItemController {

    @Autowired
    private InventoryItemService inventoryItemService;

    @GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<InventoryItem> getItem(@PathVariable Long id) {
        return inventoryItemService.getItemById(id);
    }

    @PostMapping
    public InventoryItem createItem(@RequestBody InventoryItem item) {
        return inventoryItemService.addItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        inventoryItemService.deleteItem(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItem> updateItem(
            @PathVariable Long id,
            @Valid @RequestBody InventoryItem updatedItem) {
    
        return inventoryItemService.getItemById(id)
                .map(existingItem -> {
                    existingItem.setType(updatedItem.getType());
                    existingItem.setName(updatedItem.getName());
                    existingItem.setSizeOrVariant(updatedItem.getSizeOrVariant());
                    existingItem.setQuantityAvailable(updatedItem.getQuantityAvailable());
                    existingItem.setUnitPrice(updatedItem.getUnitPrice());
                    existingItem.setDescription(updatedItem.getDescription());
                    existingItem.setIsActive(updatedItem.getIsActive());
                    return ResponseEntity.ok(inventoryItemService.addItem(existingItem));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/item-names")
    public List<String> getAllItemNames() {
        return inventoryItemService.getAllItemNames();
    }
}
    
