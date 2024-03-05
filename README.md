# Car Rental Management System

The Car Rental Management System is a web application designed to facilitate the rental of cars. It consists of a frontend built with Angular and a backend built with Spring Boot. The system provides functionalities for both administrators and customers. Administrators can log in, manage car listings (add, update, delete), while customers can browse available cars, book them, and view their bookings.

## Features

- CRUD operations for Cars and Rentals.
- RESTful API for communication between frontend and backend.
- MySQL database for data storage.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Architecture](#architecture)
- [Usage](#usage)
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

### Backend (Spring Boot)
1. Clone the repository to your local machine.
2. Open the backend project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Configure the MySQL database connection in `src/main/resources/application.properties`.
4. Run the Spring Boot application (`CarRentalSystem.java`).
5. The server will start at `http://localhost:8090`.

### Frontend (Angular)
1. Navigate to the `frontend` directory.
2. Run `npm install` to install dependencies.
3. Configure the API base URL in `src/environments/environment.ts` to point to your backend server.
4. Run `ng serve` to start the Angular development server.
5. The frontend will be accessible at `http://localhost:4200`.

## Architecture
The system follows a client-server architecture:

### Backend (Spring Boot)
- **Controllers**: 
    - `AdminController`: Handles admin-related operations such as car management.
    - `CustomerController`: Handles customer-related operations such as booking cars.
    - `AuthController`: Handles user authentication.
- **Services**: 
    - `CarService`: Provides CRUD operations for car management.
    - `BookingService`: Manages bookings made by customers.
    - `UserService`: Manages user authentication and authorization.
- **Security**: 
    - JWT Authentication Filter: Validates user credentials and generates JWT tokens.
    - Authorization: Implements role-based access control for different endpoints.
- **Database**: 
    - MySQL is used to store car information, user data, and bookings.

### Frontend (Angular)
- **Components**: 
    - `AdminComponent`: Admin dashboard for managing cars.
    - `CustomerComponent`: Customer dashboard for browsing and booking cars.
    - `LoginComponent`: User authentication and login.
- **Services**: 
    - `CarService`: Handles API requests related to car management.
    - `AuthService`: Handles user authentication and JWT token management.
- **Routing**: 
    - Angular Router is used to navigate between different components.
- **User Interface**: 
    - UI components built with Angular Material for a consistent and responsive design.

## Usage
1. **Admin Actions**:
    - Log in as an admin using valid credentials.
    - Access the admin dashboard to manage cars (add, update, delete).
2. **Customer Actions**:
    - Log in as a customer using valid credentials.
    - Browse available cars and view details.
    - Book cars for desired dates.
3. **Authentication**:
    - JWT tokens are used for authentication.
    - Tokens are sent with each API request for authorization.


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

