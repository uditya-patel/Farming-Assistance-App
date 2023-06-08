package com.capgemini.farmingAssistanceSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.farmingAssistanceSystem.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
