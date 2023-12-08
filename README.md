# redbox: A Comprehensive DVD Management System

## Introduction
redbox is an advanced DVD management system designed to streamline the operations of DVD rentals and returns. It offers a robust platform for administrators and users to interact with DVD data, manage accounts, and handle transactions efficiently.

## Features
- **DVD Management**: Add, delete, modify, and query DVDs in the system (CRUD).
- **User Account Management**: Admins can manage user accounts, including creation, modification, and deletion.
- **Transaction Handling**: Facilitates borrowing and returning of DVDs with approval workflows.
- **Logging**: Tracks administrative and user activities for audit and monitoring.

## Software Architecture
This project is developed using Java Swing for the user interface and JDBC for database interaction, showcasing a practical implementation of GUI development and database management in Java.

## Development Environment
- **Java JDK 1.8**: Ensures compatibility and performance.
- **MySQL 8.0**: Provides a robust database solution.
- **IDEA or any Java Compiler**: For code compilation and execution.

## Getting Started
1. **Import the Project**: Clone the repository and import it into your Java IDE.
2. **Database Setup**: Execute the `redbox.sql` script to set up the database schema. Customize the database configuration in `src/utils/DbUtil.java`.
3. **Run the Application**: Start the application by running `src/Main.java`.

## Detailed Overview
- **Main Entry**: The application starts at `Main.java`, initializing the user interface.
- **User Interface**: Swing-based UI components are located under `src/ui`, providing a user-friendly interface for interaction.
- **Data Access Objects (DAOs)**: `src/dao` contains DAO classes for handling database operations for different entities like DVDs, users, and transactions.
- **Beans**: The `src/bean` directory contains classes representing different entities such as `Dvd`, `User`, `Borrow`, etc.

## Contributions
Contributions to redbox are welcome. Please read our contribution guidelines before submitting a pull request.
