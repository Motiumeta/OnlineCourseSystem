🎓 Online Course System

A structured, console-based Online Course System built in Java. This application simulates a learning platform where users can authenticate, manage courses, handle lessons, and take assessments. The project follows a modular architecture with a clear separation between core logic and data entities.

✨ Features
🔐 User Authentication – Secure login and registration system (Authentication.java).

📚 Course Management – Create, view, and manage courses (ManageCourse.java).

📝 Enrollment System – Users can enroll in available courses.

📖 Lessons – Courses are divided into structured lessons.

📊 Assessments & Quizzes – Supports multiple question types, including Multiple Choice (Choice.java) and Short Answer (ShortAnswer.java).

📈 Results – Users can view their performance and results (Result.java).

💾 Database Integration – Centralized data management via a DB interface (DB.java).

🧠 Concepts Demonstrated
Object-Oriented Programming (OOP) – Heavy use of inheritance and polymorphism (e.g., Question as a base class for Choice and ShortAnswer).

Modular Architecture – Clear separation of concerns:

core: Contains the application logic, menus, and user interaction.

entities: Contains the data models (Users, Courses, Lessons, Questions).

Authentication Flow – Managing user sessions and state (Authentication.currentUser).

Data Persistence – Structured data handling via DB.java.

Utility Classes – Reusable helper methods for input validation and formatting (Utility.java).

🏗️ Project Structure
The project is organized into two main packages to keep the codebase clean:

📁 core (Application Logic)
File	Responsibility
App.java	The entry point. Checks if a user is authenticated and routes to the Auth page or Home page.
Authentication.java	Handles login, registration, and session management.
Home.java	The main dashboard/menu for logged-in users.
ManageCourse.java	Logic for adding, editing, and viewing courses.
Result.java	Handles grading and displaying user results.
DB.java	Acts as a mock database or file handler for data storage.
Utility.java	Helper functions (e.g., console formatting, input validation).
📁 entities (Data Models)
File	Responsibility
User.java	Represents a user (student/instructor) with credentials and profile info.
Course.java	Represents a course with its details.
Enrollement.java	Links a User to a Course.
Lesson.java	Represents a single lesson within a course.
Questions/Question.java	Base class for all types of assessment questions.
Questions/Choice.java	Inherits from Question; handles multiple-choice questions.
Questions/ShortAnswer.java	Inherits from Question; handles open-ended text answers.
Main.java	(If applicable) Alternative entry point or test harness.
🚀 How to Run
Clone the repository

bash
git clone https://github.com/Motiumeta/OnlineCourseSystem.git
cd OnlineCourseSystem
Compile the project
Because the project uses packages, compile from the root directory:

bash
javac core/*.java entities/*.java entities/Questions/*.java
Run the application

bash
java core.App
Requires Java 8 or higher.

💻 Application Flow
When you run the application, the App.java class determines the starting point:

java
if (Authentication.currentUser == null) {
    Authentication.authPage(); // Redirects to Login/Register
} else {
    Home.homePage();           // Redirects to Dashboard
}
Login/Register: New users must create an account; returning users log in.

Dashboard (Home): From here, users can navigate to Course Management, view their enrolled courses, and take lessons/quizzes.

Quizzes: Users can answer Choice or ShortAnswer questions, and their scores are calculated by Result.java.

📌 Notes & Limitations
Data persistence depends on the implementation of DB.java (likely in-memory or simple text files for this lab).

The UI is currently text-based (console).

Security is basic (simulated authentication) and suitable for educational purposes, not production.

🔮 Possible Improvements
Transition the UI to JavaFX or Swing for a graphical experience.

Implement a real relational database (MySQL/PostgreSQL) using JDBC.

Add password hashing (e.g., BCrypt) for better security.

Allow instructors to create courses and students to only view them (Role-Based Access Control).

👤 Author
Motiumeta
GitHub: @Motiumeta
