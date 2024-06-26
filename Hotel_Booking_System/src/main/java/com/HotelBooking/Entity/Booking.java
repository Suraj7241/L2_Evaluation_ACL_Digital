package com.HotelBooking.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
	private String guestName;
	private String roomType;
	private String checkInDate;
	private String checkoutDate;
	private Double price;
}
