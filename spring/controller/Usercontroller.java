package com.project.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.spring.model.User;
import com.project.spring.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;


@RestController
public class Usercontroller {

	private static final String REGISTRATION_COLLECTION = "userlist";

	@Autowired
	private UserService userService;

	ArrayList<User> list = new ArrayList<User>();



	@RequestMapping(method = RequestMethod.GET, value = "user/get/{emailId}")
	public Optional<User> getUser(@PathVariable String emailId) {
		return userService.getUser(emailId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "user/get")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@RequestMapping(method = RequestMethod.GET, value = "user/get/mobileNo/{mobileNo}")
	public User getUserByMobileNo(@PathVariable Long mobileNo) {
		return userService.getUserByMobileNo(mobileNo);
	}

	@RequestMapping(method = RequestMethod.GET, value = "user/get/userName/{userName}")
	public User getUserByName(@PathVariable String userName) {
		return userService.getUserByName(userName);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "user/delete/{emailId}")
	public void deleteUser(String emailId) {
		userService.deleteUser(emailId);	
	}


	@RequestMapping( value="/register", method=RequestMethod.GET )
	public String getregisterForm() {
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String addUser(@ModelAttribute(name="user1") User user, Model model) { 
		 userService.addUser(user);
		 return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginForm() {
		return "login";
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String validatate(@ModelAttribute(name="user") User user) {
		
		String exitPoint = "User not there ";
		boolean value = userService.isPresent(user.getEmailId());
		list = (ArrayList<User>) userService.searchAll();
		for (User index : list) {
			if (value && user.getPassword().equals(index.getPassword())) {
			exitPoint= "User successfully logged in";
			}

		}
		return "index";
	}
	
	
	
	 





/*	

	@ApiOperation(value="it will return user list")
	@RequestMapping(method = RequestMethod.GET, value = "user/get/{emailId}")
	public Optional<User> getUser(@PathVariable String emailId) {
		return userService.getUser(emailId);
	}

	@ApiOperation(value="it will return all list of user")
	@RequestMapping(method = RequestMethod.GET, value = "user/get")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@ApiOperation(value="it will return user based on mobile number")
	@RequestMapping(method = RequestMethod.GET, value = "user/get/mobileNo/{mobileNo}")
	public User getUserByMobileNo(@PathVariable Long mobileNo) {
		return userService.getUserByMobileNo(mobileNo);
	}

	@ApiOperation(value="it will return user based on name")
	@RequestMapping(method = RequestMethod.GET, value = "user/get/userName/{userName}")
	public User getUserByName(@PathVariable String userName) {
		return userService.getUserByName(userName);
	}

	@ApiOperation(value="it will delete user based on emailId")
	@RequestMapping(method = RequestMethod.DELETE, value = "user/delete/{emailId}")
	public void deleteUser(String emailId) {
		userService.deleteUser(emailId);	
	}

	@ApiOperation(value="add user in User list")
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String addUser(@RequestBody  User user) { 
		String response= userService.addUser(user);
		return response;
	}


	@ApiOperation(value="login user if username and password is correct")
	@RequestMapping(method=RequestMethod.GET, value="/login/{userName}/{password}")
	public String validatate(@PathVariable String emailId, @PathVariable String password) {

		String response=userService.validatate(emailId, password);	
		return response;

	}*/
}
