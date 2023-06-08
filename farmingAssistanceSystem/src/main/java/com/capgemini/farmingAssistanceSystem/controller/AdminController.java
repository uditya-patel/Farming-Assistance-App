package com.capgemini.farmingAssistanceSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.farmingAssistanceSystem.entity.Complaint;
import com.capgemini.farmingAssistanceSystem.entity.User;
import com.capgemini.farmingAssistanceSystem.exception.ComplaintNotFoundException;
import com.capgemini.farmingAssistanceSystem.service.AdminService;
import com.capgemini.farmingAssistanceSystem.service.Userservice;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private Userservice userservice;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> registerAdmin(@RequestBody User user) {
		
		String RegisterMessage = userservice.registerAdmin(user);
		return new ResponseEntity<>(RegisterMessage, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/viewComplaint")
	public ResponseEntity<Complaint> getComplaint(@RequestParam Integer id) throws ComplaintNotFoundException {
		
		Complaint complaint =  adminService.getComplaint(id);
		
		return new ResponseEntity<>(complaint, HttpStatus.FOUND);
		
	}
	
	@PutMapping("/updateComplaint")
	public ResponseEntity<String> updateComplaint(@RequestBody Complaint complaint) throws ComplaintNotFoundException{
		
		return new ResponseEntity<>(adminService.updateComplaint(complaint), HttpStatus.OK);
	}

}
