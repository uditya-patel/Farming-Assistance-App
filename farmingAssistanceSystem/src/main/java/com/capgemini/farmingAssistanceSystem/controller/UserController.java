package com.capgemini.farmingAssistanceSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.farmingAssistanceSystem.entity.User;
import com.capgemini.farmingAssistanceSystem.service.Userservice;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private Userservice userService;

	@PostMapping("/register/farmer")
	public ResponseEntity<String> registerFarmer(@RequestBody User user) {
		
		String RegisterMessage = userService.registerFarmer(user);
		return new ResponseEntity<>(RegisterMessage, HttpStatus.CREATED);	
	}
	

	@PostMapping("/register/supplier")
	public ResponseEntity<String> registerSuppiler(@RequestBody User user) {
		
		String RegisterMessage = userService.registerSuppiler(user);
		return new ResponseEntity<>(RegisterMessage, HttpStatus.CREATED);
		
	}



}
