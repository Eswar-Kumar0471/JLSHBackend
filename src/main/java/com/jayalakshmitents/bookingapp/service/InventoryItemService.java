package com.jayalakshmitents.bookingapp.service;

import com.jayalakshmitents.bookingapp.model.InventoryItem;
import com.jayalakshmitents.bookingapp.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryItemService {

    @Autowired
    private InventoryItemRepository repository;

    public List<InventoryItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<InventoryItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public InventoryItem addItem(InventoryItem item) {
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public InventoryItem updateItem(Long id, InventoryItem updatedItem) {
        InventoryItem existingItem = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
    
        existingItem.setType(updatedItem.getType());
        existingItem.setName(updatedItem.getName());
        existingItem.setSizeOrVariant(updatedItem.getSizeOrVariant());
        existingItem.setQuantityAvailable(updatedItem.getQuantityAvailable());
        existingItem.setUnitPrice(updatedItem.getUnitPrice());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setIsActive(updatedItem.getIsActive());
    
        return repository.save(existingItem);
    }
    public List<String> getAllItemNames() {
        return repository.findAllItemNames();
    }
}
