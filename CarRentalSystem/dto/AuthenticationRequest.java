package com.carrentalapp.CarRentalSystem.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {
	
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
}