# Student Management System

This is a Student Management System project developed using Spring MVC, MySQL database, and Thymeleaf for view templates.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Usage](#usage)
- [License](#license)

## Features
1. **CRUD Operations:** Perform basic CRUD operations (Create, Read, Update, Delete) for student entities.
2. **MySQL Database:** Integration with MySQL database for data storage.
3. **Thymeleaf Views:** Utilize Thymeleaf templating engine for dynamic HTML views.
4. **Navbar:** Implement a navigation bar using Thymeleaf for easy navigation across the application.

## Prerequisites
- Java Development Kit (JDK) 11 or later
- Apache Maven
- MySQL Server
- IDE (IntelliJ IDEA)

## Setup
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/student-management-system.git
   cd student-management-system
   ```

2. **Database Configuration:**
    - Create a MySQL database and update the `application.properties` file with your database configuration.
    - Example `application.properties`:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
      spring.datasource.username=your_username
      spring.datasource.password=your_password
      ```

3. **Build and Run:**
    - Build the project using Maven:
      ```bash
      mvn clean install
      ```
    - Run the application:
      ```bash
      java -jar target/student-management-system.jar
      ```

## Usage
- Access the application through your web browser at [http://localhost:8080](http://localhost:8080).
- Navigate through the application using the provided navigation bar.
- Perform CRUD operations on student entities.

## License
This project is licensed under the [MIT License](LICENSE).
