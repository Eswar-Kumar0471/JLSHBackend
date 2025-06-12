package com.jayalakshmitents.bookingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_items")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    @NotBlank(message = "Type is required")
    private String type;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(name = "size_or_variant")
    private String sizeOrVariant;

    @Column(name = "quantity_available")
    @NotNull(message = "Quantity is required")
    private int quantityAvailable;

    @Column(name = "unit_price")
    @NotNull(message = "Unit Price is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Unit price must be positive")
    private BigDecimal unitPrice;

    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSizeOrVariant() {
        return sizeOrVariant;
    }

    public void setSizeOrVariant(String sizeOrVariant) {
        this.sizeOrVariant = sizeOrVariant;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // No setter for createdAt since it's handled by DB
}
