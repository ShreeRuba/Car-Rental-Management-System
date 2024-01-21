# Car Rental Management System

This project is a Car Rental Management System built with Spring Boot (backend) and Angular (frontend). It allows users to manage information about cars and rental bookings.

## Features

- CRUD operations for Cars and Rentals.
- RESTful API for communication between frontend and backend.
- MySQL database for data storage.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)


## Prerequisites

- Java JDK 11 or higher
- Node.js and npm
- MySQL database

## Technologies Used

- **Backend:**
  - Spring Boot
  - Spring Data JPA
  - MySQL

- **Frontend:**
  - Angular


## Project Structure

The project follows a standard structure for a Spring Boot application with separate packages for controllers, services, models, and repositories. Similarly, the Angular frontend is organized with components, services, and modules.
project

```plaintext
car-rental
|-- backend
|   |-- src
|       |-- main
|           |-- java
|               |-- com.example.carrental
|                   |-- controller
|                   |-- model
|                   |-- repository
|                   |-- service
|                   |-- CarRentalApplication.java
|           |-- resources
|               |-- application.properties
|-- frontend
|   |-- src
|       |-- app
|       |-- ...
|-- pom.xml
|-- ...
```


## Setup Instructions

1. **Backend:**
   - Open the backend project in eclipse IDE.
   - Configure the database connection in `src/main/resources/application.properties`.
   - Run the Spring Boot application (`CarRentalApplication.java`).

2. **Frontend:**
   - Open the frontend project in your preferred code editor (e.g., Visual Studio Code).
   - Update the API endpoint URLs in the service files.
   - Run the Angular application (`ng serve`).

## Usage

1. Access the application by navigating to `http://localhost:4200` in your web browser.
2. Use the provided UI to manage cars and book rentals.
3. Explore the API endpoints for further integration.

## API Endpoints

- **Cars:**
  - `GET /api/cars`: Retrieve all cars.
  - `GET /api/cars/{id}`: Retrieve a specific car by ID.
  - `POST /api/cars`: Create a new car.
  - `DELETE /api/cars/{id}`: Delete a car by ID.

- **Rentals:**
  - `GET /api/rentals`: Retrieve all rentals.
  - `GET /api/rentals/{id}`: Retrieve a specific rental by ID.
  - `POST /api/rentals`: Create a new rental.
  - `DELETE /api/rentals/{id}`: Delete a rental by ID.

