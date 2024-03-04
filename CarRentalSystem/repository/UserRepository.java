package com.carrentalapp.CarRentalSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrentalapp.CarRentalSystem.entity.User;
import com.carrentalapp.CarRentalSystem.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
	
	Optional<User> findFirstByEmail(String email);

	User findByUserRole(UserRole admin);
}
