package com.cbf.cbf.repositories;

import com.cbf.cbf.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
