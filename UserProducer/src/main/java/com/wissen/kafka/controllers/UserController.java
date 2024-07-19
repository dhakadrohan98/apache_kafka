package com.wissen.kafka.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.wissen.kafka.dto.User;

 
@RestController

@RequestMapping("/userapi")

public class UserController 

{

	@Autowired

	private com.wissen.kafka.service.UserProducerService service;

	// @PostMapping("/nagendraData/{name}/{age}")

	@PostMapping("/nagendraData")

	// public void sendUserData(@PathVariable("name") String name, @PathVariable("age") int age)

	public void sendUserData(@RequestBody User user)

	{

		// service.sendUserData(name, age);

		service.sendUserData(user);

	}

}
