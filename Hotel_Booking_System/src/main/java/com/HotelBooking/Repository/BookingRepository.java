package com.HotelBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelBooking.Entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
