package io.javabrains.springbootData.dataService;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootData.model.Passenger;
import io.javabrains.springbootData.repository.PassengerRepository;


@RestController
public class PassengerDataService {


	/*private MongoOperations mongoOps;*/
	private static final String PASSENGER_COLLECTION = "Passenger";
	
	/*public PassengerDAOImpl(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}
	*/
	@Autowired
	private PassengerRepository passengerDAO;
	
	@RequestMapping(method=RequestMethod.POST, value="passenger/create")
	public void addPassenger(@RequestBody Passenger passenger) {
		passengerDAO.save(passenger);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="passenger/get")
	public List<Passenger> getAllPassenger() {
		return passengerDAO.findAll();
	} 
	
	@RequestMapping(method=RequestMethod.GET, value="passenger/get/{id}")
	public Optional<Passenger> getPassenger(@PathVariable String id) {
		return passengerDAO.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="passenger/update/{id}")
	public void updatePassenger(@RequestBody Passenger passenger, @PathVariable String id) {
		passengerDAO.save(passenger);
				
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="passenger/delete/{id}")
	public void deletePassenger(@PathVariable String id) {
		passengerDAO.deleteById(id);
	} 

}


