package com.jayalakshmitents.bookingapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.jayalakshmitents.bookingapp.entity.BookingItem;
import com.jayalakshmitents.bookingapp.entity.BookingStatus;

import jakarta.persistence.*; // or javax.persistence.* depending on version
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bookings") // Optional, to set custom table name
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(name = "customer_name", nullable = false)
    @NotBlank(message = "Customer name is required")
    @Getter
    @Setter
    private String customerName;

    @Column(name = "phone_number", nullable = false)
    @Getter
    @Setter
    private String phoneNumber;

    @SuppressWarnings("unused")
    @Column(name = "event_date", nullable = false)
    @Getter
    @Setter
    private LocalDate eventDate;

    @SuppressWarnings("unused")
    @Column(name = "event_location", nullable = false)
    @Getter
    @Setter
    private String eventLocation;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Getter
    @Setter
    private BookingStatus status;

    @SuppressWarnings("unused")
    @Column(name = "created_at", nullable = false)
    @Getter
    @Setter
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter
    @Setter
    private List<BookingItem> itemsBooked = new ArrayList<>();

    // Getters, Setters, Constructors

    public BookingStatus getStatus() {
        return status;
    }
    
    public void setStatus(BookingStatus status) {
        this.status = status;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
protected void onCreate() {
    this.createdAt = LocalDateTime.now();
}
    
}
