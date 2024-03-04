package com.carrentalapp.CarRentalSystem.services.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carrentalapp.CarRentalSystem.dto.SignupRequest;
import com.carrentalapp.CarRentalSystem.dto.UserDto;
import com.carrentalapp.CarRentalSystem.entity.User;
import com.carrentalapp.CarRentalSystem.enums.UserRole;
import com.carrentalapp.CarRentalSystem.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@PostConstruct
	public void createAdminAccount() {
		User adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
		if (adminAccount == null) {
			User newAdminAccount = new User();
			newAdminAccount.setName("Admin");
			newAdminAccount.setEmail("admin@test.com");
			newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
			newAdminAccount.setUserRole(UserRole.ADMIN);
			userRepository.save(newAdminAccount);
			System.out.println("Admin Account created Successfully");
		}
	}
	
	@Override
	public UserDto createCustomer(SignupRequest signupRequest) {
		
		User user = new User();
		user.setName(signupRequest.getName());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
		user.setUserRole (UserRole.CUSTOMER);
		User createdUser = userRepository.save(user);
		UserDto userDto = new UserDto();
		userDto.setId(createdUser.getId());
		return userDto;
	}
		
		
	@Override
	public boolean hasCustomerWithEmail (String email) {
		return userRepository.findFirstByEmail(email).isPresent();
	}
	}
	

