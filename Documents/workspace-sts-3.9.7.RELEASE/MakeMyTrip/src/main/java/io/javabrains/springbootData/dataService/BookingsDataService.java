package io.javabrains.springbootData.dataService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootData.model.Bookings;

import io.javabrains.springbootData.repository.BookingsRepository;


@RestController
public class BookingsDataService {
	
	private static final String BOOKINGS_COLLECTION = "Bookings";
	
	@Autowired
	private BookingsRepository bookingsDAO;
	
	@RequestMapping(method=RequestMethod.POST, value="bookings/create")
	public void addBookings(@RequestBody Bookings bookings) {
		bookingsDAO.save(bookings);	
	}

	// this should be accessed by only admin 
	@RequestMapping(method=RequestMethod.GET, value="bookings/get")
	public List<Bookings> getAllBookings() {
		return bookingsDAO.findAll();
	} 
	
// This should be accessed by passenger. where he can only get the information of his booking
	@RequestMapping(method=RequestMethod.GET, value="bookings/get/{pnr}")
	public Optional<Bookings> getBookingsByPNR(@PathVariable String pnr) {
		return bookingsDAO.findById(pnr);
	} 
	
	@RequestMapping(method=RequestMethod.DELETE, value="bookings/delete/{pnr}")
	public void deleteBookings(@PathVariable String pnr) {
		bookingsDAO.deleteById(pnr);
		
	}

}
