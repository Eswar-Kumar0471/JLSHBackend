package com.jayalakshmitents.bookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayalakshmitents.bookingapp.entity.BookingStatus;
import com.jayalakshmitents.bookingapp.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // You’ll get findAll, save, findById, deleteById for free!
    long countByStatus(BookingStatus status);
}
