package com.cbf.cbf.services;

import com.cbf.cbf.entities.Booking;
import com.cbf.cbf.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public void addBooking(Booking booking){
        bookingRepository.save(booking);
    }

    public List<Booking> getBookings(){
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByUser(){
        return bookingRepository.findAll();
    }
}
