
---

# Student Management System

A simple console-based **Student Management System** (SMS) written in Java, demonstrating the use of Object-Oriented Programming (OOP), file handling, and collections. The system allows you to manage student records including adding, updating, deleting, and viewing students.

## Features

- **Add Student**: Create a new student with attributes like ID, name, age, and grade.
- **View All Students**: Display a list of all students stored in the system.
- **Update Student**: Modify the details of an existing student by ID.
- **Delete Student**: Remove a student from the system by ID.
- **Data Persistence**: Student data is saved in a file (`students.dat`) using Java serialization, and automatically loaded when the program is run.

## Technologies Used

- **Java**: Core programming language.
- **File Handling**: For persistent storage of student data.
- **Serialization**: To save and load student data from the file system.
- **Collections**: Using `ArrayList` for dynamic storage of student objects.

## Project Structure

```bash
├── Main.java
├── Student.java
├── StudentManager.java
└── README.md
```

- `Main.java`: Entry point of the application. Contains the menu-driven system to interact with the user.
- `Student.java`: A class representing the student object with attributes such as `id`, `name`, `age`, and `grade`.
- `StudentManager.java`: Contains methods to manage student records, including adding, updating, deleting, and saving/loading data from a file.

## Getting Started

### Prerequisites

Ensure you have the following software installed:

- **Java Development Kit (JDK)**: You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://openjdk.java.net/).
- A terminal or IDE to run Java programs (e.g., IntelliJ, Eclipse, VSCode).

### Installing

1. Clone or download the project:
   ```bash
   git clone https://github.com/shreeyash-ugale/Student-Database.git
   ```

2. Navigate into the project directory:
   ```bash
   cd Student-Database
   ```

### Compiling and Running the Project

#### Compile the project:

```bash
javac Main.java StudentManager.java Student.java
```

#### Run the application:

```bash
java Main
```

### Usage

Once the program is running, you will be presented with a menu:

```
--- Student Management System ---
1. Add Student
2. View All Students
3. Update Student
4. Delete Student
5. Exit
```

Follow the on-screen prompts to perform any of the available operations.

#### Adding a Student

- Enter the student's ID, name, age, and grade when prompted.

#### Viewing All Students

- The system will display all the student records available.

#### Updating a Student

- Enter the ID of the student you wish to update. You will then be prompted to input new details.

#### Deleting a Student

- Enter the ID of the student to delete their record from the system.

#### Exiting the Application

- Select option `5` to safely exit the program. All data will be saved automatically.

### File Persistence

Student data is saved in a file named `students.dat`. If the file does not exist, it will be created when the first student is added. The file is loaded each time the program starts, so you do not lose data between sessions.

---

### Future Enhancements (Not required to implement as of now)

Here are some possible improvements for the project:

- Add search functionality for students by name or grade.
- Implement data validation to prevent invalid inputs.
- Use a database (e.g., MySQL, SQLite) for data storage instead of file serialization.
- Create a graphical user interface (GUI) using JavaFX or Swing.

---

Enjoy coding!

---

This README file provides an overview, instructions, and context for the project, making it easy for others to understand and use your project.
