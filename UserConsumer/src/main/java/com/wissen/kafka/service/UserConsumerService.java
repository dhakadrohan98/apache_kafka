package com.wissen.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wissen.kafka.dto.User;

@Service
public class UserConsumerService {
	@KafkaListener(topics = { "user-topic" })
//	public void consumerUserData(int age)
	public void consumerUserData(User user) {
		System.out.println("user Age is : " + user.getAge() + ". user name is " + user.getName()
				+ ". user department is : " + user.getDept());
	}
}
