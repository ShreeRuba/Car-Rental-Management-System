package com.example.CarRentalApplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Custom queries if needed
}
