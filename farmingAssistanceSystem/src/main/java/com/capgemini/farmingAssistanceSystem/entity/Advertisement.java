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
@Table(name = "Advertisements")
public class Advertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "advertisement_id")
	private Long addId;
	
	@Column(name = "crop_name")
	private String cropName;
	
	@Column(name = "quantity_required")
	private Integer quantityRequired;
	
	@Column(name = "advertisement_status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private User supplier;

	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Advertisement(Long addId, String cropName, Integer quantityRequired, String status, User supplier) {
		super();
		this.addId = addId;
		this.cropName = cropName;
		this.quantityRequired = quantityRequired;
		this.status = status;
		this.supplier = supplier;
	}



	public Long getAddId() {
		return addId;
	}

	public void setAddId(Long addId) {
		this.addId = addId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public Integer getQuantityRequired() {
		return quantityRequired;
	}

	public void setQuantityRequired(Integer quantityRequired) {
		this.quantityRequired = quantityRequired;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getSupplier() {
		return supplier;
	}

	public void setSupplier(User supplier) {
		this.supplier = supplier;
	}
	
	

}
