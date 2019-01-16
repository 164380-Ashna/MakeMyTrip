package io.javabrains.springbootData.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bookings")
public class Bookings {

	@Id
	private String pnr;
	Date BookingDate;
	String FlightName;
	String PassengerName;
	String source;
	String destination;
	Date departureDate;
	Date arrivalDate;
	double price;
	
	public Bookings() {
		super();
	}
	
	
// This constructor is for passenger when he wants to see his booking details
	public Bookings(String pnr, Date bookingDate, String flightName, String passengerName, String source,
			String destination, Date departureDate, Date arrivalDate, double price) {
		super();
		this.pnr = pnr;
		BookingDate = bookingDate;
		FlightName = flightName;
		PassengerName = passengerName;
		this.source = source;
		this.destination = destination;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.price = price;
	}
	
	



	public String getFlightName() {
		return FlightName;
	}


	public void setFlightName(String flightName) {
		FlightName = flightName;
	}


	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public Date getBookingDate() {
		return BookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}

	public String getPassengerName() {
		return PassengerName;
	}

	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

}
