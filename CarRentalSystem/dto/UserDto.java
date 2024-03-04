package com.carrentalapp.CarRentalSystem.dto;

import com.carrentalapp.CarRentalSystem.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {
	
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	private String name;
	private String email;
	
	private UserRole userRole;
}
