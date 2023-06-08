package com.capgemini.farmingAssistanceSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.farmingAssistanceSystem.entity.Complaint;
import com.capgemini.farmingAssistanceSystem.exception.ComplaintNotFoundException;
import com.capgemini.farmingAssistanceSystem.repository.ComplaintRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
//	@Autowired
//	private AdminRepository adminRepository;
	
	@Autowired
	private ComplaintRepository complaintRepository;
	
	@Override
	public String updateComplaint(Complaint complaint) throws ComplaintNotFoundException {
		Optional<Complaint> _complaint =  complaintRepository.findById(complaint.getId());
		
		if(_complaint.isPresent()) {
			_complaint.get().setStatus(complaint.getStatus());
//			_complaint.get().setComplaintMessage(complaint.getComplaintMessage());
			complaintRepository.save(_complaint.get());
			return "Complaint updated successfully";
		}
		throw new ComplaintNotFoundException("Complaint not Found with complaintId "+ complaint.getId());
	}

	@Override
	public Complaint getComplaint(Integer id) throws ComplaintNotFoundException {
		Optional<Complaint> complaint = complaintRepository.findById(id);
		if(complaint.isPresent()) {
			return complaint.get();
		}
		throw new ComplaintNotFoundException("Complaint not Found with complaintId "+ id);
	}

}
