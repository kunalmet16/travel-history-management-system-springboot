package com.travelmanagement.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelmanagement.config.MessageConfig;
import com.travelmanagement.models.Travel;
import com.travelmanagement.services.TravellerService;

@Component
public class TravelConsumer {

	
	  @Autowired TravellerService travellerService;
	  
	  
	  
	  @RabbitListener(queues=MessageConfig.QUEUE) 
	  public void consumeTravel(Travel travel) { 
		  boolean x=travellerService.addTravels(travel);
		 
		 System.out.println(x);
	  }
}
