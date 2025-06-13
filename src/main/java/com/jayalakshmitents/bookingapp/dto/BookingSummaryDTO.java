package com.jayalakshmitents.bookingapp.dto;

public class BookingSummaryDTO {
    private long total;
    private long pending;
    private long confirmed;
    private long cancelled;

    // Constructors
    public BookingSummaryDTO(long total, long pending, long confirmed, long cancelled) {
        this.total = total;
        this.pending = pending;
        this.confirmed = confirmed;
        this.cancelled = cancelled;
    }

    // Getters and Setters
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPending() {
        return pending;
    }

    public void setPending(long pending) {
        this.pending = pending;
    }

    public long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    public long getCancelled() {
        return cancelled;
    }

    public void setCancelled(long cancelled) {
        this.cancelled = cancelled;
    }
}
