package com.carrentalapp.CarRentalSystem.services.auth.jwt;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
	
	UserDetailsService userDetailsService();

}
