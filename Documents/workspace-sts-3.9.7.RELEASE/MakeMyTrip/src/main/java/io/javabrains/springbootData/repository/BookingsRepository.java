package io.javabrains.springbootData.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.javabrains.springbootData.model.Bookings;


public interface BookingsRepository extends MongoRepository<Bookings, String>{
	
	

}
