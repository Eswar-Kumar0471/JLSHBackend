package com.jayalakshmitents.bookingapp.repository;

import com.jayalakshmitents.bookingapp.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    // You can add custom query methods here if needed later
}
