# 📚 Library Management System

A console-based Library Management System developed using **Java Core**. This project focuses on applying Object-Oriented Programming (OOP) concepts, managing library operations, handling exceptions, and organizing code into maintainable and reusable components.

The main goal of this project is to strengthen practical Java programming skills through building a real-world application.

## 🚀 Features

- **Book Management**
  - Add new books.
  - Search for books.
  - Remove books.
  - Check book availability.
  - Prevent duplicate book entries.

- **Member Management**
  - Register library members.
  - Manage member information.
  - Track borrowed books.

- **Borrowing Management**
  - Borrow available books.
  - Return borrowed books.
  - Prevent borrowing unavailable books.
  - Apply borrowing limits.

- **Validation & Exception Handling**
  - Custom exceptions for business-related errors.
  - Handle invalid operations.
  - Validate data before performing operations.

## 🛠️ Technologies & Concepts

- Java Core
- Object-Oriented Programming (OOP)
  - Encapsulation
  - Inheritance
  - Polymorphism
  - Abstraction
- Collections Framework
  - ArrayList
  - List
  - Set / Map (where applicable)
- Exception Handling
- Custom Exceptions
- Method Overriding
- `equals()` and `hashCode()`
- Code Organization using Packages
- Interfaces and Abstract Classes

## 📂 Project Structure

```text
LibraryManagementSystem/
│
├── src/
│   ├── Entities/
│   │   ├── Book.java
│   │   ├── Member.java
│   │   └── Library.java
│   │
│   ├── Services/
│   │
│   ├── Interfaces/
│   │
│   └── Exceptions/
│       ├── BookAlreadyExistsException.java
│       └── BookNotFoundException.java
│
└── README.md
```

*Note: Adjust the package and file names above to match the final project structure.*

## 🧠 Key Learning Objectives

This project was built to practice and understand:

1. Designing classes and defining responsibilities.
2. Applying OOP principles in a practical application.
3. Managing related objects using Java Collections.
4. Implementing custom exceptions to handle business rules.
5. Overriding `equals()` and `hashCode()` for object comparison.
6. Separating entities, interfaces, and business logic.
7. Writing reusable and maintainable Java code.

## ⚙️ Getting Started

### Requirements

- Java JDK 17 or later.
- IntelliJ IDEA or any Java-compatible IDE.

### Installation

1. Clone the repository:

```bash
git clone https://github.com/MohammedYa/Library-Management-System
```

2. Open the project in IntelliJ IDEA.

3. Make sure the JDK is properly configured.

4. Run the main application class.

## 🔮 Future Improvements

Potential improvements for future versions:

- Integrate a database using JDBC.
- Implement persistent data storage.
- Add Stream API for filtering and processing collections.
- Add more advanced search and sorting operations.
- Introduce unit testing using JUnit.
- Improve architecture and apply SOLID principles.

## 👨‍💻 Author

**Mohamed Yasser**

Java Developer | Learning Java Backend Development

---

⭐ This project is part of my journey toward becoming a Java Backend Developer.
