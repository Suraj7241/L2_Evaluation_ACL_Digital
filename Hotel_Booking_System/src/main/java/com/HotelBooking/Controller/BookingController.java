package com.HotelBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.HotelBooking.Entity.Booking;
import com.HotelBooking.Exception.ResourceNotFoundException;
import com.HotelBooking.Service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	//get all bookings
	@GetMapping
	public ResponseEntity<List<Booking>> getAllBooking(){
		List<Booking> bookings = bookingService.getAllBooking();
		return ResponseEntity.ok().body(bookings);
	}
	
	//get by id Booking
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getById(@PathVariable Long id){
		Booking booking = bookingService.getBookingById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Booking Not Found,Please Enter Valid id !!") );
		return ResponseEntity.ok().body(booking);
	}
	
	//create new Booking
	@PostMapping
	public ResponseEntity<Booking> newBooking(@RequestBody Booking booking){
		Booking newBookings = bookingService.NewBooking(booking);
		return ResponseEntity.ok(newBookings);
	}
	
	//update Extisting booking
	@PutMapping("/{id}")
	public ResponseEntity<Booking> updateBooking (@PathVariable long id, @RequestBody Booking booking){
		Booking updateBooking = bookingService.updateBooking(id, booking);
	return ResponseEntity.ok(updateBooking);
	}
	
	//delete by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deteteById(@PathVariable Long id){
		bookingService.deleteBookingById(id);
		return ResponseEntity.noContent().build();
	}
	
	//delete All booking
	@DeleteMapping
	public ResponseEntity<Void> deleteAll(){
		bookingService.deleteAllBookings();
		return ResponseEntity.noContent().build();
	}

}
