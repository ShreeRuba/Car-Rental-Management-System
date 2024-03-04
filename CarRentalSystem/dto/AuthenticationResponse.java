package com.carrentalapp.CarRentalSystem.dto;

import com.carrentalapp.CarRentalSystem.enums.UserRole;

import lombok.Data;

@Data
public class AuthenticationResponse {
	
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	private String jwt;
	private UserRole userRole;
	private Long userId;
}
