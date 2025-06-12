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
}
