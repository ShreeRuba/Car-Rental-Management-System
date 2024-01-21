package com.example.CarRentalApplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    // Custom queries if needed
}
