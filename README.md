# Store Management System

## Description
This is a **Java console-based Store Management System** that allows users to manage products and generate bills efficiently.  
The system demonstrates the use of **Object-Oriented Programming (OOP)** concepts, **JDBC**, and **MySQL** for database management.

---

## Features
1. Add new products to the database.
2. Update existing product details.
3. Delete products from the database.
4. Generate bills for purchased products.
5. Console-based menu for easy interaction.

---

## Technologies Used
- **Java** – Core programming language.
- **OOP Concepts** – Classes, objects, encapsulation, inheritance, and polymorphism.
- **JDBC** – Java Database Connectivity to interact with MySQL.
- **MySQL** – Database to store product information.

---

## How to Run
1. Make sure **Java JDK** and **MySQL** are installed on your system.
2. Clone or download this repository.
3. Import the project into your Java IDE (Eclipse, IntelliJ, etc.).
4. Create the required **MySQL database and products table**.
5. Update database connection details in your `DBConnection.java` file.
6. Compile and run the `Main.java` file.
7. Follow the console menu to perform operations.

---

## Database
- Database Name: `store_db` (example)
- Table Name: `product`
- Columns:
  - `product_id` (INT, Primary Key, Auto Increment)
  - `product_name` (VARCHAR)
  - `price` (DOUBLE)
  - `quantity` (INT)
  - `unit` (VARCHAR)
  - `category` (VARCHAR)
- Ensure the database is running before executing the program.

---

## Author
**Shramika Poojary**
