package com.HotelBooking.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.HotelBooking.Entity.Booking;
import com.HotelBooking.Exception.ResourceNotFoundException;
import com.HotelBooking.Repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getAllBooking(){
		return bookingRepository.findAll();
	}
	
	public Optional <Booking> getBookingById (long id){
		return bookingRepository.findById(id);
	}
	
	public Booking NewBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	public Booking updateBooking(long id,Booking bookedDetails) {
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Booking Not Found,Please Enter Correct Id."));
	booking.setGuestName(bookedDetails.getGuestName());
	booking.setRoomType(bookedDetails.getRoomType());
	booking.setCheckInDate(bookedDetails.getCheckInDate());
	booking.setCheckoutDate(bookedDetails.getCheckoutDate());
	booking.setPrice(bookedDetails.getPrice());
	return bookingRepository.save(booking);
	}
	
	public void deleteAllBookings() {
		bookingRepository.deleteAll();
	}
	
	public void deleteBookingById(Long id) {
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Booking Not Found,Please Enter Valid Id."));
	    bookingRepository.deleteById(id);
	}

}
