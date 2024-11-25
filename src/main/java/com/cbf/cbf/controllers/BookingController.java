package com.cbf.cbf.controllers;

import com.cbf.cbf.entities.Booking;
import com.cbf.cbf.entities.Fair;
import com.cbf.cbf.entities.User;
import com.cbf.cbf.services.BookingService;
import com.cbf.cbf.services.FairService;
import com.cbf.cbf.services.UserService;
import com.cbf.cbf.tdos.BookingTdos;
import com.cbf.cbf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @Autowired
    UserService userService;

    @Autowired
    FairService fairService;

    @GetMapping
    public ResponseEntity<?> getBookings() {
        return new ResponseEntity<>(bookingService.getBookings(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingTdos bookingTdos) {
        Optional<Fair> fair = fairService.getFairById(bookingTdos.getFId());
        Optional<User> user = userService.getUserById(bookingTdos.getUId());

        if (fair.isPresent() && user.isPresent()) {
            Booking booking = new Booking();
            booking.setCreatedAt(Utils.getDate());
            booking.setUpdatedAt(Utils.getDate());
            booking.setFair(fair.get());
            booking.setUser(user.get());
            booking.setDate(bookingTdos.getDate());
            booking.setActive(true);
            booking.setTickets(bookingTdos.getTickets());

            bookingService.addBooking(booking);
            return ResponseEntity.ok("Added successfully!");
        }
        return ResponseEntity.ok("Fair or user not found!");
    }
}
