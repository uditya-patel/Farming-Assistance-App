package com.capgemini.farmingAssistanceSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ComplaintNotFoundException.class)
	public ResponseEntity<String> complaintNotFound( ComplaintNotFoundException complaintNotFoundException) {
		
		return new ResponseEntity<>(complaintNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FarmerNotFoundException.class)
	public ResponseEntity<String> farmerNotFound(FarmerNotFoundException farmerNotFoundException) {
		return new ResponseEntity<>(farmerNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFound(ProductNotFoundException productNotFoundException) {
		return new ResponseEntity<>(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SupplierNotFoundException.class)
	public ResponseEntity<String> supplierNotFound(SupplierNotFoundException supplierNotFoundException) {
		return new ResponseEntity<>(supplierNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AdvertisementNotFoundException.class)
	public ResponseEntity<String> AdvertisementNotFound(AdvertisementNotFoundException advertisementNotFoundException) {
		return new ResponseEntity<>(advertisementNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<String> InvalidData(InvalidDataException invalidDataException) {
		return new ResponseEntity<>(invalidDataException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> OrderNotFound(OrderNotFoundException orderNotFoundException) {
		return new ResponseEntity<>(orderNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StockUnavailableException.class)
	public ResponseEntity<String> StockUnavailable(StockUnavailableException stockUnavailableException) {
		return new ResponseEntity<>(stockUnavailableException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
