package io.javabrains.springbootData.model;

import org.springframework.data.annotation.Id;

public class Passenger {

   
	@Id 
	

	private int id; 
	 	String passengerName;  
	 	String email; 
	 	String password; 
	 	Bookings bookings; 
	 	 
	 	public Passenger() { 
 		super(); 
	 	} 
	 	 
	 	 
	 	public Passenger(int id, String passengerName, String email, String password) { 
	 		super(); 
	 		this.id = id; 
	 		this.passengerName = passengerName; 
	 		this.email = email; 
	 		this.password = password; 
 	} 
	 	
	
	 
	 	public int getId() { 
			return id; 
	 	} 
	 
	 
	 	public void setId(int id) { 
	 		this.id = id; 
	 	} 
	 
	 
		public String getPassengerName() { 
	 		return passengerName; 
	 	} 
	 
	 
	 	public void setPassengerName(String passengerName) { 
	 		this.passengerName = passengerName; 
	 	} 
	 
	 
	 	public String getEmail() { 
	 		return email; 
	 	} 
	 	public void setEmail(String email) { 
	 		this.email = email; 
	 	} 
	 
	 
	 	public String getPassword() { 
	 		return password; 
	 	} 
	 
	 
	 	public void setPassword(String password) { 
	 		this.password = password; 
	 	} 
	 	 
	 } 

	
	

