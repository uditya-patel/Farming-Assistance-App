package com.capgemini.farmingAssistanceSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import com.capgemini.farmingAssistanceSystem.repository.AdvertisementRepository;
import com.capgemini.farmingAssistanceSystem.repository.ComplaintRepository;
import com.capgemini.farmingAssistanceSystem.repository.OrderRepository;
import com.capgemini.farmingAssistanceSystem.repository.ProductRepository;
import com.capgemini.farmingAssistanceSystem.repository.UserRepository;
@Service
public class UserServiceImpl implements Userservice {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ComplaintRepository complaintRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AdvertisementRepository advertisementRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	

	@Override
	public String registerAdmin(User user) {
		user.setRole("ROLE_ADMIN");
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userRepository.save(user);
		return "registered successfully";
	}


	@Override
	public User getFarmerById(Integer id) throws FarmerNotFoundException {
		Optional<User> user =  userRepository.findById(id);
		if(user.isPresent() && user.get().getRole().equals("ROLE_FARMER")) {
			return user.get();
		}
		throw new FarmerNotFoundException("No Farmer found with farmerId "+ id);
	}


	@Override
	public String updateFarmer(User user) throws FarmerNotFoundException {
		User userDb = userRepository.findByEmail(user.getEmail());
		if(userDb!=null) {
			
			userDb.setName(user.getName());
			userDb.setEmail(user.getEmail());
			userDb.setAddress(user.getAddress());
			userDb.setGender(user.getGender());
			userDb.setMobile(user.getMobile());
			userRepository.save(userDb);
			
			return "update successfully";
		}
		throw new FarmerNotFoundException("No Farmer found with farmerId "+ userDb.getId());
	}


	@Override
	public String registerFarmer(User user) {
		user.setRole("ROLE_FARMER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userRepository.save(user);
		return "registered successfully";
		
	}


	@Override
	public String registerSuppiler(User user) {
		user.setRole("ROLE_SUPPLIER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userRepository.save(user);
		return "registered successfully";
	}


	@Override
	public String addComplaint(Integer farmerId, Complaint complaint) throws FarmerNotFoundException {
		Optional<User> user = userRepository.findById(farmerId);
		if (user.isPresent() && user.get().getRole().equals("ROLE_FARMER")) {
			complaint.setFarmer(user.get());
			complaintRepository.save(complaint);
			return "Complaint added successfully with complaintId "+ complaint.getId();
		}
		throw new FarmerNotFoundException("No Farmer found with farmerId "+ farmerId + " so cannot add complaints.");
		
		
		
	}


	@Override
	public Complaint getComplaint(Integer id) throws ComplaintNotFoundException {
		Optional<Complaint> complaint = complaintRepository.findById(id);
		if(complaint.isPresent()) {
			return complaint.get();
		}
		throw new ComplaintNotFoundException("Complaint not Found with complaintId "+ id);
	}


	@Override
	public String updateComplaint(Complaint complaint) throws ComplaintNotFoundException {
		Optional<Complaint> _complaint =  complaintRepository.findById(complaint.getId());
		
		if(_complaint.isPresent()) {
			_complaint.get().setComplaintMessage(complaint.getComplaintMessage());
			complaintRepository.save(_complaint.get());
			return "Complaint updated successfully";
		}
		throw new ComplaintNotFoundException("Complaint not Found with complaintId "+ complaint.getId());
	}


	@Override
	public String deleteComplaint(Integer id) throws ComplaintNotFoundException {
		Optional<Complaint> complaintDb = complaintRepository.findById(id);
		
		if(complaintDb.isPresent()) {
			complaintRepository.delete(complaintDb.get());
			return "Your complaint got deleted successfuly with complaintId "+ id;
		}
		throw new ComplaintNotFoundException("Complaint not Found with complaintId "+ id);
	}


	@Override
	public String addProduct(Integer farmerId, Product product) throws FarmerNotFoundException {
		Optional<User> user = userRepository.findById(farmerId);
		if (user.isPresent() && user.get().getRole().equals("ROLE_FARMER")) {
				product.setFarmer(user.get());
				productRepository.save(product);
				return "Product added successfully with productId "+ product.getProductId();
			}
			throw new FarmerNotFoundException("No Farmer found with farmerId "+ farmerId + " so cannot add products.");
			
	}


	@Override
	public Product getproductbyId(Long productId) throws ProductNotFoundException {
		Optional<Product> productDb = productRepository.findById(productId);
		if(productDb.isPresent()) {
			return productDb.get();
		}
		throw new ProductNotFoundException("Product not Found with productId "+ productId);
	}


	@Override
	public String updateProduct(Product product) throws ProductNotFoundException {
		Optional<Product> productDb =  productRepository.findById(product.getProductId());
		
		if(productDb.isPresent()) {
			productDb.get().setProductName(product.getProductName());
			productDb.get().setProductUnitPrice(product.getProductUnitPrice());
			productDb.get().setProductQuantity(product.getProductQuantity());
			productRepository.save(productDb.get());
			return "Prodtc updated successfully";
		}
		throw new ProductNotFoundException("Product not Found with productId "+ product.getProductId());
	}


	@Override
	public String deleteProduct(Long productId) throws ProductNotFoundException {
		Optional<Product> productDb = productRepository.findById(productId);
		
		if(productDb.isPresent()) {
			productRepository.delete(productDb.get());
			return "Your product got deleted successfuly with productId "+ productId;
		}
		throw new ProductNotFoundException("Product not Found with productId "+ productId);
	}


	@Override
	public List<Product> getAllProduct(Integer farmerId) throws ProductNotFoundException {
		
		List<Product> products =  productRepository.getAllProductByFarmer(farmerId);
		
		if(products.isEmpty()) {
			throw new ProductNotFoundException("Products not Found with given farmerId "+ farmerId);
		}
		
		return products;
		
	}


	@Override
	public User getSupplierById(Integer id) throws SupplierNotFoundException {
		Optional<User> userDb =  userRepository.findById(id);
		if(userDb.isPresent() && userDb.get().getRole().equals("ROLE_SUPPLIER")) {
			return userDb.get();
		}
		throw new SupplierNotFoundException("No Supplier found with suplierId "+ id);
	}


	@Override
	public String updateSupplier(User user) throws SupplierNotFoundException {
		User userDb = userRepository.findByEmail(user.getEmail());
		if(userDb!=null) {
			
			userDb.setName(user.getName());
			userDb.setEmail(user.getEmail());
			userDb.setAddress(user.getAddress());
			userDb.setGender(user.getGender());
			userDb.setMobile(user.getMobile());
			userRepository.save(userDb);
			
			return "update successfully";
		}
		throw new SupplierNotFoundException("No Supplier found with suplierId "+ userDb.getId());
	}


	@Override
	public String postAddvertisement(Integer supplierId, Advertisement advertisement) throws AdvertisementNotFoundException {
		
		Optional<User> userDb = userRepository.findById(supplierId);
		if (userDb.isPresent() && userDb.get().getRole().equals("ROLE_SUPPLIER")) {
			advertisement.setSupplier(userDb.get());
			advertisementRepository.save(advertisement);
			return "Advertisement posted successfully with advertisementId "+ advertisement.getAddId();
		}
		throw new AdvertisementNotFoundException("No Supplier found with supplierId "+ supplierId + " so cannot post Advertisements.");
		
		
		
		
	}


	@Override
	public Advertisement getAddvertisementById(Long addId) throws AdvertisementNotFoundException {
		Optional<Advertisement> AdvertisementDb = advertisementRepository.findById(addId);
		if(AdvertisementDb.isPresent()) {
			return AdvertisementDb.get();
		}
		throw new AdvertisementNotFoundException("Advertisement not Found with addvertisementId "+ addId);
		
	}


	@Override
	public List<Advertisement> getAllAdvertisement(Long supplierId) throws AdvertisementNotFoundException {
		List<Advertisement> advertisements =  advertisementRepository.getAllAdvertisementBySupplier(supplierId);
		
		if(advertisements.isEmpty()) {
			throw new AdvertisementNotFoundException("Advertisement not Found with given supplierId "+ supplierId);
		}
		
		return advertisements;
	}


	@Override
	public String updateAdvertisement(Advertisement advertisement) throws AdvertisementNotFoundException {
		Optional<Advertisement> advertisementDb =  advertisementRepository.findById(advertisement.getAddId());
		
		if(advertisementDb.isPresent()) {
			advertisementDb.get().setCropName(advertisement.getCropName());
			advertisementDb.get().setQuantityRequired(advertisement.getQuantityRequired());
			advertisementDb.get().setStatus(advertisement.getStatus());
			advertisementRepository.save(advertisementDb.get());
			return "Advertisement updated successfully";
		}
		throw new AdvertisementNotFoundException("Advertisement not Found with advertisementId "+ advertisement.getAddId());
	}


	@Override
	public String deleteAddvertisement(Long addvertisementId) throws AdvertisementNotFoundException {
		Optional<Advertisement> addvertisementDb = advertisementRepository.findById(addvertisementId);
		
		if(addvertisementDb.isPresent()) {
			advertisementRepository.delete(addvertisementDb.get());
			return "Your advertisement got deleted successfuly with addvertisementId "+ addvertisementId;
		}
		throw new AdvertisementNotFoundException("Advertisement not Found with advertisementId "+ addvertisementId);
	}


	@Override
	public List<Advertisement> getAllAdvertisement() {
		
		List<Advertisement> advertisements = advertisementRepository.findAll();
		
		return advertisements;
	}


	@Override
	public User getSupplierByAdvertisementId(Long advertisementId) throws SupplierNotFoundException, AdvertisementNotFoundException {
		
		Optional<Advertisement> addvertisementDb = advertisementRepository.findById(advertisementId);
		
		if(addvertisementDb.isPresent()) {
			
			User supplierDb = advertisementRepository.getSupplierByAdvertisement(advertisementId);
			
			if(supplierDb!=null) {
				return supplierDb;
			}else {
				
				throw new SupplierNotFoundException("Supplier not found with given advertisementId "+ advertisementId);
				
			}
				
		}else {
			
			throw new AdvertisementNotFoundException("Advertisement not Found with advertisementId "+ advertisementId);

		}
		
		
		 
		
	}


	@Override
	public String createOrder(Long productId, Integer supplierId, Order order) throws InvalidDataException, StockUnavailableException {
		
		Optional<Product> productsDb = productRepository.findById(productId);
		Optional<User> supplierDb = userRepository.findById(supplierId);
		
		if(productsDb.isPresent() && supplierDb.isPresent()) {
			
			if(order.getQuantiityRequired()<=productsDb.get().getProductQuantity()) {
				
				order.setSupplier(supplierDb.get());
				productsDb.get().setProductQuantity(productsDb.get().getProductQuantity() - order.getQuantiityRequired());
				
				productRepository.save(productsDb.get());
				order.addProduct(productsDb.get());
				
				order.setStatus("not accepted");
				
				orderRepository.save(order);
				
				return "order created successfully for supplier with supplierId " + supplierId + " with orderId " + order.getOrderId();
				
			}
			
			throw new StockUnavailableException("The product is out of stock or you have entered a required quantity more than available.");
			
		}
		
		throw new InvalidDataException("check your input data.");
		
	}


	@Override
	public String updateOrderStatus(Long orderId, String newOorderStatus) throws OrderNotFoundException {
		
		Optional<Order> orderDb = orderRepository.findById(orderId);
		
		if(orderDb.isPresent()) {
			if(orderDb.get().getStatus().equalsIgnoreCase("not accepted")) {
				orderDb.get().setStatus(newOorderStatus);
				
				orderRepository.save(orderDb.get());
				
				return "order status is updated successfully as "+ newOorderStatus;
			}
			else {
				return "order status is already as ACCEPTED";
			}
		}
		throw new OrderNotFoundException("order not found with orderId "+ orderId);
		
	}


	@Override
	public Order viewOrder(Long orderId) throws OrderNotFoundException {
		
		Optional<Order> orderDb = orderRepository.findById(orderId);
		
		if(orderDb.isPresent()) {
			return orderDb.get();
		}
		
		throw new OrderNotFoundException("No order found with orderId "+ orderId);
	}
	
}
