package com.capgemini.farmingAssistanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.farmingAssistanceSystem.entity.Complaint;
@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

}
