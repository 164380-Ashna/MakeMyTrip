package io.javabrains.springbootData.dao;

import java.util.List;

import io.javabrains.springbootData.model.Passenger;

public interface IPassengerDao {
	

	void deletePassenger(int id);
	void updatePassenger(Passenger pasenger);
	Passenger getPassenger(int id);
	void addPassenger(Passenger passenger);
	List<Passenger> getAllPassenger();

}
