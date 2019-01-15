package io.javabrains.springbootData.dao;


import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import com.mongodb.WriteResult;

import io.javabrains.springbootData.model.Passenger;

public class PassengerDao implements IPassengerDao {

	private MongoOperations mongoOps;
	private static final String PASSENGER_COLLECTION = "Passenger";
	
	public PassengerDao(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}
	
	@Override
	public void addPassenger(Passenger passenger) {
		this.mongoOps.insert(passenger, PASSENGER_COLLECTION);
	}

	@Override
	public Passenger getPassenger(int id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, Passenger.class, PASSENGER_COLLECTION);
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		this.mongoOps.save(passenger, PASSENGER_COLLECTION);
	}

	@Override
	public void deletePassenger(int id) {
		Query query = new Query(Criteria.where("_id").is(id));
		this.mongoOps.remove(query, Passenger.class, PASSENGER_COLLECTION);	
	}

	@Override
	public List<Passenger> getAllPassenger() {
		return this.mongoOps.findAll(Passenger.class, PASSENGER_COLLECTION);
	}

}