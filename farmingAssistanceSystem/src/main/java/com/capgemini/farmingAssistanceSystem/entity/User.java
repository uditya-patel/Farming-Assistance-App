package com.capgemini.farmingAssistanceSystem.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_user")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_password")
	private String password;
	
	@Column(name = "user_mobile")
	private Long mobile;
	
	@Column(name = "user_address")
	private String address;
	
	@Column(name = "user_gender")
	private String gender;
	
//	@Column(name = "user_id")
//	private String profileImage;
	
	@Column(name = "user_role")
	private String role;
	
	@OneToMany(mappedBy = "farmer")
	@JsonIgnore
	private Set<Complaint> complaints;
	
	@OneToMany(mappedBy = "farmer")
	@JsonIgnore
	private Set<Product> products;
	
	@OneToMany(mappedBy = "supplier")
	@JsonIgnore
	private Set<Advertisement> advertisements;
	
	@OneToOne(mappedBy = "supplier")
	@JsonIgnore
	private Order order;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(Integer id, String name, String email, String password, Long mobile, String address, String gender,
			String role, Set<Complaint> complaints, Set<Product> products,
			Set<Advertisement> advertisements, Order order) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.gender = gender;
		this.role = role;
		this.complaints = complaints;
		this.products = products;
		this.advertisements = advertisements;
		this.order = order;
	}







	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	public Set<Complaint> getComplaints() {
		return complaints;
	}


	public void setComplaints(Set<Complaint> complaints) {
		this.complaints = complaints;
	}



	public Set<Product> getProducts() {
		return products;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}



	public Set<Advertisement> getAdvertisements() {
		return advertisements;
	}



	public void setAdvertisements(Set<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	


//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobile="
//				+ mobile + ", address=" + address + ", gender=" + gender + ", profileImage=" + profileImage + ", role="
//				+ role + "]";
//	}
	
	
	

}
