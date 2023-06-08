package com.capgemini.farmingAssistanceSystem.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	
	@Column(name = "quantity_required")
	private Integer quantiityRequired;
		
	@Column(name = "order_status")
	private String status;

	
	@OneToOne
	@JoinColumn(name = "supplier_id")
	private User supplier;
	
	@ManyToMany()
	@JoinTable(name = "order_products",
		joinColumns = { @JoinColumn(name = "order_id") },
		inverseJoinColumns = { @JoinColumn(name = "product_id") })
	private Set<Product> products = new HashSet<>();

	public Order() {
		super();
	}

	public Order(Long orderId, Integer quantiityRequired, Set<Product> products, User supplier, String status) {
		super();
		this.orderId = orderId;
		this.quantiityRequired = quantiityRequired;
//		this.price = price;
		this.products = products;
		this.supplier = supplier;
		this.status = status;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getQuantiityRequired() {
		return quantiityRequired;
	}

	public void setQuantiityRequired(Integer quantiityRequired) {
		this.quantiityRequired = quantiityRequired;
	}

	

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public User getSupplier() {
		return supplier;
	}

	public void setSupplier(User supplier) {
		this.supplier = supplier;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
		
		product.getOrders().add(this);
		
		
	}
	
	
	
	
	
	

}
