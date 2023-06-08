package com.capgemini.farmingAssistanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.farmingAssistanceSystem.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {

}
