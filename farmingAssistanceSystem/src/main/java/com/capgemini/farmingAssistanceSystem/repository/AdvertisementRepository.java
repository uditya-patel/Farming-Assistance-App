package com.capgemini.farmingAssistanceSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.farmingAssistanceSystem.entity.Advertisement;
import com.capgemini.farmingAssistanceSystem.entity.User;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long>{
	
	@Query("SELECT a FROM Advertisement a  WHERE a.supplier.id = :supplierId")
	public List<Advertisement> getAllAdvertisementBySupplier(Long supplierId);
	
	@Query("SELECT u FROM User u JOIN u.advertisements a WHERE a.addId = :AdvertisementId")
	public User getSupplierByAdvertisement(Long AdvertisementId);

}
