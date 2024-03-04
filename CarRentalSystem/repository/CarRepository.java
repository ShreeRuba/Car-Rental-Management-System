package com.carrentalapp.CarRentalSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrentalapp.CarRentalSystem.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

}
