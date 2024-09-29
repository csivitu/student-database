import java.io.*;  // Import for I/O operations
import java.util.ArrayList; // Import ArrayList
import java.util.List; // Import List


public class StudentManager{
    private List<Student> studentList;
    private final String FILE_NAME = "students.dat";

    public StudentManager() {
        studentList = new ArrayList<>(); // Initialize ArrayList
        loadFromFile();  // Load from file on initialization
    }

    public void addStudent(Student student) {
        studentList.add(student);  // Add student to the list
        saveToFile();  // Save the updated list to file
    }

    // Return a Student object instead of String
    public Student getStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Return null if no student is found
    }

    public void updateStudent(int id, String name, int age, String grade) {
        Student student = getStudentById(id);  // Fetch the student by ID
        if (student != null) {  // Ensure the student exists
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            saveToFile();  // Save the updated student data to file
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(int id) {
        Student student = getStudentById(id);  // Fetch the student by ID
        if (student != null) {  // Ensure the student exists
            studentList.remove(student);  // Remove the student
            saveToFile();  // Save the updated list to file
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);  // Display each student's information
            }
        }
    }

    public  void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentList);  // Write the list of students to file
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentList = (List<Student>) ois.readObject();  // Load the list of students from file
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}