package com.capgemini.farmingAssistanceSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Complaints")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comaplaint_id")
	private Integer id;
	
	@Column(name = "comaplaint_message")
	private String ComplaintMessage;
	
	@Column(name = "comaplaint_status")
	private String Status = "Unread";
	
	@ManyToOne
	@JoinColumn(name = "farmer_id")
	private User farmer;

	public Complaint() {
		super();
	}


	public Complaint(Integer id, String complaintMessage, String status, User farmer) {
		super();
		this.id = id;
		ComplaintMessage = complaintMessage;
		Status = status;
		this.farmer = farmer;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComplaintMessage() {
		return ComplaintMessage;
	}

	public void setComplaintMessage(String complaintMessage) {
		ComplaintMessage = complaintMessage;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}


	public User getFarmer() {
		return farmer;
	}


	public void setFarmer(User farmer) {
		this.farmer = farmer;
	}
	
	
	

}
