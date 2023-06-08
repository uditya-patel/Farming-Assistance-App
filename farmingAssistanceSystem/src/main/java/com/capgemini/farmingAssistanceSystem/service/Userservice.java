package com.capgemini.farmingAssistanceSystem.service;

import java.util.List;

import com.capgemini.farmingAssistanceSystem.entity.Advertisement;
import com.capgemini.farmingAssistanceSystem.entity.Complaint;
import com.capgemini.farmingAssistanceSystem.entity.Order;
import com.capgemini.farmingAssistanceSystem.entity.Product;
import com.capgemini.farmingAssistanceSystem.entity.User;
import com.capgemini.farmingAssistanceSystem.exception.AdvertisementNotFoundException;
import com.capgemini.farmingAssistanceSystem.exception.ComplaintNotFoundException;
import com.capgemini.farmingAssistanceSystem.exception.FarmerNotFoundException;
import com.capgemini.farmingAssistanceSystem.exception.InvalidDataException;
import com.capgemini.farmingAssistanceSystem.exception.OrderNotFoundException;
import com.capgemini.farmingAssistanceSystem.exception.ProductNotFoundException;
import com.capgemini.farmingAssistanceSystem.exception.StockUnavailableException;
import com.capgemini.farmingAssistanceSystem.exception.SupplierNotFoundException;

public interface Userservice {

	String registerAdmin(User user);

	User getFarmerById(Integer id) throws FarmerNotFoundException;

	String updateFarmer(User user) throws FarmerNotFoundException;

	String registerFarmer(User user);

	String registerSuppiler(User user);

	String addComplaint(Integer farmerId,Complaint complaint) throws FarmerNotFoundException;

	Complaint getComplaint(Integer id) throws ComplaintNotFoundException;

	String updateComplaint(Complaint complaint) throws ComplaintNotFoundException;

	String deleteComplaint(Integer id) throws ComplaintNotFoundException;

	String addProduct(Integer farmerId, Product product) throws FarmerNotFoundException;

	Product getproductbyId(Long productId) throws ProductNotFoundException;

	String updateProduct(Product product) throws ProductNotFoundException;

	String deleteProduct(Long productId) throws ProductNotFoundException;

	List<Product> getAllProduct(Integer farmerId) throws ProductNotFoundException;

	User getSupplierById(Integer id) throws SupplierNotFoundException;

	String updateSupplier(User user) throws SupplierNotFoundException;

	String postAddvertisement(Integer supplierId, Advertisement advertisement) throws AdvertisementNotFoundException;

	Advertisement getAddvertisementById(Long addId) throws AdvertisementNotFoundException;

	List<Advertisement> getAllAdvertisement(Long supplierId) throws AdvertisementNotFoundException;

	String updateAdvertisement(Advertisement advertisement) throws AdvertisementNotFoundException;

	String deleteAddvertisement(Long addvertisementId) throws AdvertisementNotFoundException;

	List<Advertisement> getAllAdvertisement();

	User getSupplierByAdvertisementId(Long advertisementId) throws SupplierNotFoundException, AdvertisementNotFoundException;

	String createOrder(Long productId, Integer supplierId, Order order) throws InvalidDataException, StockUnavailableException;

	String updateOrderStatus(Long orderId, String newOorderStatus) throws OrderNotFoundException;

	Order viewOrder(Long orderId) throws OrderNotFoundException;

}
