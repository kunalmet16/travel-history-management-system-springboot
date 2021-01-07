package com.travelmanagement.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.travelmanagement.config.MessageConfig;
import com.travelmanagement.models.Country;
import com.travelmanagement.models.Travel;


import com.travelmanagement.models.UserLogin;
import com.travelmanagement.services.TravellerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MyResource {

	@Autowired
	TravellerService travellerService;
	
	@Autowired
     RabbitTemplate template;
	
	@GetMapping("/")
	public String welcome()
	{
		return "<h1>Welcome to Travel History Management System</h1>";
	}
	
			
	@PostMapping("/login")
	public boolean getUserValidity(@RequestBody UserLogin user)
	{
		
		/*
		 * if(travellerService.getUserValidity(user)==false) { throw new
		 * ResponseStatusException(HttpStatus.UNAUTHORIZED); }
		 */
		return travellerService.getUserValidity(user);
		 
	}
	
	@PostMapping("/signup")
	public boolean signup(@RequestBody UserLogin user)
	{
		 String json=travellerService.signup(user);
		 if(json==null)
			 return false;
		 return true;
		 
		 
	}
	
	@GetMapping("/users/{username}/travels")
	public List<Travel> getAllTravels(@PathVariable("username") String name)
	{
		return travellerService.getAllTravels(name);
	}
	
	@PostMapping("/users/{username}/travels")
	public boolean addTravels(@RequestBody Travel travel,@PathVariable("username")String username)
	{
		travel.setUserlogin(new UserLogin(username,""));
		return travellerService.addTravels(travel);
	}
	
	@PutMapping("/users/{username}/travels/{id}")
	public void updateTravel(@RequestBody Travel travel,@PathVariable("id") int id,@PathVariable("username") String name)
	{
		
		travellerService.updateTravel(travel,name,id);
	}
	
	@GetMapping("/users/{username}/country/{country}")
	public List<Country> getTravelsByCountry(@PathVariable("country") String country,@PathVariable("username") String username)
	{
		return travellerService.getTravelsByCountry(country,username);
	}
	
	
	
	
	
	
	
	
	
	
	
}
