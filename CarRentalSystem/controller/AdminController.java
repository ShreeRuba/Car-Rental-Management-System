package com.carrentalapp.CarRentalSystem.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalapp.CarRentalSystem.dto.CarDto;
import com.carrentalapp.CarRentalSystem.services.admin.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService adminService;
	public AdminController (AdminService adminService) {
		this.adminService = adminService;
	}
	
	@PostMapping("/car")
	public ResponseEntity<CarDto> postCar(@ModelAttribute CarDto carDto) throws IOException {
		boolean success = adminService.postCar(carDto);
		if (success) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}

	}
	
	@GetMapping("/cars")
	public ResponseEntity<?> getAllCars() {
		return ResponseEntity.ok(adminService.getAllCars());
	}
	
	@DeleteMapping("/car/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable Long id){
		adminService.deleteCar(id);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/car/{id}")
	public ResponseEntity<?> getCarById(@PathVariable Long id){
		CarDto carDto = adminService.getCarById(id);
		return ResponseEntity.ok(carDto);
	}
	
	@PutMapping("/car/{carId}")
	public ResponseEntity<Void> updateCar (@PathVariable Long carId, @ModelAttribute CarDto carDto) throws IOException {
		try {
			boolean success = adminService.updateCar(carId, carDto);
			if (success) return ResponseEntity.status(HttpStatus.OK).build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
	}
}
