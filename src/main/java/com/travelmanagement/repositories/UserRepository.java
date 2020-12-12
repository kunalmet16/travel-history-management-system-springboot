package com.travelmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.travelmanagement.models.UserLogin;

public interface UserRepository extends CrudRepository<UserLogin,String>{
	
	public UserLogin findByName(String name);

}
