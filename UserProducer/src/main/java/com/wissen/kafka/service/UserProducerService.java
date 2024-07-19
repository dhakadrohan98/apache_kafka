package com.wissen.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wissen.kafka.dto.User;

@Service
public class UserProducerService {
	
	//private KafkaTemplate<String, Integer> kafkaTemplate;
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	

	// public void sendUserData(String name,int age)
	public void sendUserData(User user) {
		kafkaTemplate.send("user-topic", user.getName(), user);
	}
}
