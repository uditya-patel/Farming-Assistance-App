package com.capgemini.farmingAssistanceSystem.securityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capgemini.farmingAssistanceSystem.entity.User;
import com.capgemini.farmingAssistanceSystem.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository usersRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User users = usersRepo.findByEmail(email);
		if (users == null) {
			throw new UsernameNotFoundException("User Not Found");
		}else {
		return new CustomUserDetails(users);
	}
	}

}
