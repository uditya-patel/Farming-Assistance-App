package com.capgemini.farmingAssistanceSystem.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_unit_price")
	private long productUnitPrice;

	@Column(name = "product_quantity")
	private long productQuantity;
	
	@ManyToOne
	@JoinColumn(name = "farmer_id")
	private User farmer;

	
	@ManyToMany(mappedBy = "products")
	@JsonIgnore
	private Set<Order> orders = new HashSet<>();

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(long productId, String productName, long productUnitPrice, long productQuantity, User farmer,Set<Order> orders
			) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productUnitPrice = productUnitPrice;
		this.productQuantity = productQuantity;
		this.farmer = farmer;
		this.orders = orders;
	}





	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public long getProductUnitPrice() {
		return productUnitPrice;
	}


	public void setProductUnitPrice(long productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}


	public long getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}


	public User getFarmer() {
		return farmer;
	}


	public void setFarmer(User farmer) {
		this.farmer = farmer;
	}


	public Set<Order> getOrders() {
		return orders;
	}


	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	

	

	
	
	
	
	

	
	
	
}
