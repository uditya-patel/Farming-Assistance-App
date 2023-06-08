package com.capgemini.farmingAssistanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.farmingAssistanceSystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT f FROM User f WHERE f.email = ?1")
	public User findByEmail(String email);

}
