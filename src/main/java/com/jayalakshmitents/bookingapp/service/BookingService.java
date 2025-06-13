package com.jayalakshmitents.bookingapp.service;

import com.jayalakshmitents.bookingapp.model.Booking;
import com.jayalakshmitents.bookingapp.repository.BookingRepository;
import com.jayalakshmitents.bookingapp.dto.BookingSummaryDTO;
import com.jayalakshmitents.bookingapp.entity.BookingItem;
import com.jayalakshmitents.bookingapp.entity.BookingStatus;
import com.jayalakshmitents.bookingapp.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        booking.setStatus(BookingStatus.PENDING);
        booking.setCreatedAt(LocalDateTime.now());

        // Link each BookingItem back to this booking
        if (booking.getItemsBooked() != null) {
            for (BookingItem item : booking.getItemsBooked()) {
                item.setBooking(booking);
            }
        }

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + id));
    }

    public Booking updateBookingStatus(Long id, BookingStatus status) {
        Booking existing = getBookingById(id);
        existing.setStatus(status); // Only update the status
        return bookingRepository.save(existing);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existing = getBookingById(id);

        existing.setCustomerName(updatedBooking.getCustomerName());
        existing.setPhoneNumber(updatedBooking.getPhoneNumber());
        existing.setEventDate(updatedBooking.getEventDate());
        existing.setEventLocation(updatedBooking.getEventLocation());
        existing.setStatus(updatedBooking.getStatus());

        return bookingRepository.save(existing);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public BookingSummaryDTO getBookingSummary() {
        long total = bookingRepository.count();
        long pending = bookingRepository.countByStatus(BookingStatus.PENDING);
        long confirmed = bookingRepository.countByStatus(BookingStatus.CONFIRMED);
        long cancelled = bookingRepository.countByStatus(BookingStatus.CANCELLED);

        return new BookingSummaryDTO(total, pending, confirmed, cancelled);
    }

}
