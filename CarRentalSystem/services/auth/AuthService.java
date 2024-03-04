package com.carrentalapp.CarRentalSystem.services.auth;

import com.carrentalapp.CarRentalSystem.dto.SignupRequest;
import com.carrentalapp.CarRentalSystem.dto.UserDto;

public interface AuthService {
	
	UserDto createCustomer(SignupRequest signupRequest);
	
	boolean hasCustomerWithEmail(String mail);
}
