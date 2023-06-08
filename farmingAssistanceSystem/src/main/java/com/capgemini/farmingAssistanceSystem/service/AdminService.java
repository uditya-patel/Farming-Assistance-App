package com.capgemini.farmingAssistanceSystem.service;

import com.capgemini.farmingAssistanceSystem.entity.Complaint;
import com.capgemini.farmingAssistanceSystem.exception.ComplaintNotFoundException;

public interface AdminService {
	
	Complaint getComplaint(Integer id) throws ComplaintNotFoundException;
	
	String updateComplaint(Complaint complaint) throws ComplaintNotFoundException;

}
