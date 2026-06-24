What the project does
The application allows a librarian to manage a collection of books through a console interface.
Features
Library Management
Create a library with:
Name
Address
Number of employees
Book Management
Add books
Remove books
Update book information
View all books
Each book stores:
Title
Author
Publisher
Publication year
ISBN
Number of pages
Availability status
Search Functionality
Users can search books by:
Title
Author
Year
ISBN
The system filters and returns matching books.
Borrowing System
The Book class contains functionality for:
Borrowing books
Returning books
Tracking borrow dates
Due dates
Number of times borrowed
Although not fully exposed through the menu, the functionality exists in the application design.
Input Validation
The application validates:
Employee count
Publication year
Page count
ISBN length
Author name length
Book title length
which demonstrates defensive programming practices.
Technologies Used
Java
Object-Oriented Programming (OOP)
Collections Framework (ArrayList)
Console Applications
User Input Handling (Scanner)
Concepts Demonstrated
This project shows understanding of:
OOP Principles
Classes
Objects
Encapsulation
Methods
Constructors
Examples:
Book
Library
Data Structures
ArrayList<Book>
CRUD Operations
Create → Add books
Read → View/Search books
Update → Modify book information
Delete → Remove books
User Interaction
Console menu system
Input validation
Error handling
