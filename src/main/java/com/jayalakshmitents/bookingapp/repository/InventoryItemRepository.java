package com.jayalakshmitents.bookingapp.repository;

import com.jayalakshmitents.bookingapp.model.InventoryItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    // You can add custom query methods here if needed later

     @Query("SELECT i.name FROM InventoryItem i")
    List<String> findAllItemNames();
}
