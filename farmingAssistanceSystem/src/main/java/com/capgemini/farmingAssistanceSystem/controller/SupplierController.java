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
import com.capgemini.farmingAssistanceSystem.entity.User;
import com.capgemini.farmingAssistanceSystem.exception.AdvertisementNotFoundException;
import com.capgemini.farmingAssistanceSystem.exception.OrderNotFoundException;
import com.capgemini.farmingAssistanceSystem.exception.SupplierNotFoundException;
import com.capgemini.farmingAssistanceSystem.service.Userservice;
@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private Userservice userService;
	
	
	@GetMapping("/getSupplierId")
	public ResponseEntity<User> getSupplierById(@RequestParam Integer id) throws SupplierNotFoundException {
		
		User supplier = userService.getSupplierById(id);
		return new ResponseEntity<>(supplier, HttpStatus.FOUND);
		
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateSupplier(@RequestBody User user) throws SupplierNotFoundException {
		
		return new ResponseEntity<>(userService.updateSupplier(user), HttpStatus.OK);
		
		
	}
	
	@PostMapping("postAdd")
	public ResponseEntity<String> postAddvertisement(@RequestParam Integer supplierId, @RequestBody Advertisement advertisement) throws AdvertisementNotFoundException {
		
		return new ResponseEntity<>(userService.postAddvertisement(supplierId, advertisement), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAdvertisement")
    public ResponseEntity<Advertisement> getAddvertisementById(@RequestParam Long addId) throws AdvertisementNotFoundException {
       Advertisement advertisement = userService.getAddvertisementById(addId);
         return new ResponseEntity<>(advertisement, HttpStatus.OK);
        
    }
	
	@GetMapping("/getAllAdvertisement")
	public ResponseEntity<List<Advertisement>> getAllAdvertisement(@RequestParam Long supplierId) throws AdvertisementNotFoundException {
		
		List<Advertisement> advertisements = userService.getAllAdvertisement(supplierId);
		
		return new ResponseEntity<>(advertisements, HttpStatus.FOUND);
	}
	
	@PutMapping("/updateAdvertisement")
    public ResponseEntity<String> updateAdvertisement(@RequestBody Advertisement advertisement) throws AdvertisementNotFoundException {
        
        return new ResponseEntity<>(userService.updateAdvertisement(advertisement), HttpStatus.OK);
       
    }
	
	@DeleteMapping("/deleteAddvertisement")
	public ResponseEntity<String> deleteAddvertisement(@RequestParam Long addvertisementId) throws AdvertisementNotFoundException{
		
		return new ResponseEntity<>(userService.deleteAddvertisement(addvertisementId), HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/updateOrderStatus")
	public ResponseEntity<String> updateOrderStatus(@RequestParam Long orderId, @RequestParam String newOorderStatus) throws OrderNotFoundException {
		
		
		return new ResponseEntity<>(userService.updateOrderStatus(orderId, newOorderStatus), HttpStatus.OK);
	}

}
