package com.travelmanagement.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.travelmanagement.models.Country;
import com.travelmanagement.models.Travel;


public interface TravelRepository extends CrudRepository<Travel,Integer>{

	public List<Travel> findByName(String name);
	public List<Travel> findByDes(String country);
	public List<Travel> findByUserloginName(String name);
	public List<Travel> findByDesAndUserloginName(String des,String name);
}
