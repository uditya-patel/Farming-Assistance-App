package com.capgemini.farmingAssistanceSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.capgemini.farmingAssistanceSystem.service.Userservice;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	
	@Autowired
	private Userservice userService;
	
	
	@GetMapping("/getFarmerById")
	public ResponseEntity<User> getFarmerById(@RequestParam Integer id) throws FarmerNotFoundException {
		
		User user = userService.getFarmerById(id);
		return new ResponseEntity<>(user, HttpStatus.FOUND);
		
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateFarmer(@RequestBody User user) throws FarmerNotFoundException {
		
		return new ResponseEntity<>(userService.updateFarmer(user), HttpStatus.OK);
		
		
	}
	
	@PostMapping("/complaint")
	public ResponseEntity<String> addComplaint(@RequestParam Integer farmerId, @RequestBody Complaint complaint) throws Exception {
		
		return new ResponseEntity<>(userService.addComplaint(farmerId, complaint), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/viewComplaint")
	public ResponseEntity<Complaint> getComplaint(@RequestParam Integer id) throws ComplaintNotFoundException {
		
		Complaint complaint =  userService.getComplaint(id);
		
		return new ResponseEntity<>(complaint, HttpStatus.FOUND);
		
	}
	
	@PutMapping("/updateComplaint")
	public ResponseEntity<String> updateComplaint(@RequestBody Complaint complaint) throws ComplaintNotFoundException{
		
		return new ResponseEntity<>(userService.updateComplaint(complaint), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteComplaint")
	public ResponseEntity<String> deleteComplaint(@RequestParam Integer id) throws ComplaintNotFoundException {
		
		return new ResponseEntity<>(userService.deleteComplaint(id), HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/addproduct")
    public ResponseEntity<String> addProduct(@RequestParam Integer farmerId, @RequestBody Product product) throws FarmerNotFoundException {
        
         return new ResponseEntity<>(userService.addProduct(farmerId, product), HttpStatus.CREATED);
       
    }
	
	@GetMapping("/getproduct")
    public ResponseEntity<Product> getProductById(@RequestParam Long productId) throws ProductNotFoundException {
       Product product = userService.getproductbyId(productId);
         return new ResponseEntity<>(product, HttpStatus.OK);
        
    }
	
	@PutMapping("/updateproduct")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) throws ProductNotFoundException {
        
        return new ResponseEntity<>(userService.updateProduct(product), HttpStatus.OK);
       
    }
	
	@DeleteMapping("/deleteproduct")
	public ResponseEntity<String> deleteProduct(@RequestParam Long productId) throws ProductNotFoundException{
		
		return new ResponseEntity<>(userService.deleteProduct(productId), HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getAllProductByFarmer")
	public ResponseEntity<List<Product>> getAllProduct(@RequestParam Integer farmerId) throws ProductNotFoundException {
		
		List<Product> products = userService.getAllProduct(farmerId);
		
		return new ResponseEntity<>(products, HttpStatus.FOUND);
	}
	
	
	@GetMapping("/getAllAdvertisement")
	public ResponseEntity<List<Advertisement>> getAllAdvertisement() throws AdvertisementNotFoundException {
		
		List<Advertisement> advertisements = userService.getAllAdvertisement();
		
		return new ResponseEntity<>(advertisements, HttpStatus.FOUND);
	}
	
	@GetMapping("getSupplierByAdvertisement")
	public ResponseEntity<User> getSupplierByAdvertisementId(@RequestParam Long AdvertisementId) throws SupplierNotFoundException, AdvertisementNotFoundException {
		User user = userService.getSupplierByAdvertisementId(AdvertisementId);
		
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}
	
	@PostMapping("/createOrder")
	public ResponseEntity<String> createOrder(@RequestParam Long productId, @RequestParam Integer supplierId, @RequestBody Order order) throws InvalidDataException, StockUnavailableException {
		
		return new ResponseEntity<>(userService.createOrder(productId, supplierId, order), HttpStatus.CREATED);
	}
	
	@GetMapping("/viewOrder")
	public ResponseEntity<Order> viewOrder(@RequestParam Long orderId) throws OrderNotFoundException {
		
		Order order = userService.viewOrder(orderId);
		
		return new ResponseEntity<>(order, HttpStatus.FOUND);
		
	}
	
	

}
