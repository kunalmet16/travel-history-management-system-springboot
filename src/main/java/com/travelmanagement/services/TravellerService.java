package com.travelmanagement.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmanagement.models.Country;
import com.travelmanagement.models.Travel;

import com.travelmanagement.models.UserLogin;
import com.travelmanagement.repositories.TravelRepository;
import com.travelmanagement.repositories.UserRepository;

@Service
public class TravellerService {

	@Autowired
	TravelRepository travelrepository;
	
	@Autowired
	UserRepository userRepository;


	
	
	  

	public List<Country> getTravelsByCountry(String des,String name) {
		List<Country> lst = new ArrayList<Country>();
		/*
		 * travelrepository.findByDes(country).forEach(x->{ lst.add(new
		 * Country(x.getName(),x.getSt(),x.getEn())); });
		 */
		travelrepository.findByDesAndUserloginName(des, name).forEach(x->{
			lst.add(new Country(x.getSt(),x.getEn(),(int)((x.getEn().getTime() - x.getSt().getTime()) / (1000 * 60 * 60 * 24))));
			
		});
		
		System.out.println(lst);
		return lst;
	}

	public boolean getUserValidity(UserLogin user) {
		if(userRepository.findByName(user.getName())==null)
			return false;
		String x=userRepository.findByName(user.getName()).getName();
		String y=userRepository.findByName(user.getName()).getPass();
		String z=user.getName();
		String w=user.getPass();
		
		if(x!=null&&x.equals(z)&&y!=null&&y.equals(w))
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	public String signup(UserLogin user) {
		if(userRepository.findByName(user.getName())==null)
		{
			userRepository.save(user);
			
			return "Signup successful!!";
		}
		else
		{
			return null;
		}
		
	}

	public boolean addTravels(Travel travel) {
		
		  if(userRepository.findByName(travel.getUserlogin().getName())==null) 
			  return false;
		 
		
		travelrepository.save(travel);
		return true;
		
	}

	public void updateTravel(Travel travel,String name,int id) {
		travel.setUserlogin(new UserLogin(name,""));
		travel.setId(id);
		travel.setName(travelrepository.findById(id).get().getName());
		travel.setSrc(travelrepository.findById(id).get().getSrc());
		travel.setSt(travelrepository.findById(id).get().getSt());
		travelrepository.save(travel);
		}

	public Optional<Travel> getTravel(int id) {
		return travelrepository.findById(id);
		
	}

	public List<Travel> getAllTravels(String name) {
		List<Travel> lst=new ArrayList<>();
		travelrepository.findByUserloginName(name).forEach(lst::add);
		return lst;
	}
	
	
	 

}
