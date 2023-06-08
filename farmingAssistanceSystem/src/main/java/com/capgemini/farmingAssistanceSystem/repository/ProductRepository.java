package com.capgemini.farmingAssistanceSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.farmingAssistanceSystem.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
//	@Query("SELECT p FROM Product p JOIN p.farmer f WHERE f.id = :farmerId")
	@Query("SELECT p FROM Product p  WHERE p.farmer.id = :farmerId")
	public List<Product> getAllProductByFarmer(Integer farmerId);

}
