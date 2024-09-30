import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StudentManager studentManager = new StudentManager();
    int choice;

    do {
      System.out.println("\n--- Student Management System ---");
      System.out.println("1. Add Student");
      System.out.println("2. View All Students");
      System.out.println("3. Update Student");
      System.out.println("4. Delete Student");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          addStudent(studentManager, scanner);
          break;
        case 2:
          studentManager.displayAllStudents();
          break;
        case 3:
          updateStudent(studentManager, scanner);
          break;
        case 4:
          deleteStudent(studentManager, scanner);
          break;
        case 5:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    } while (choice != 5);

    scanner.close();
  }

  private static void addStudent(StudentManager studentManager, Scanner scanner) {
    System.out.print("Enter Student ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Age: ");
    int age = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Grade: ");
    String grade = scanner.nextLine();

    Student student = new Student(id, name, age, grade);
    studentManager.addStudent(student);
  }

  private static void updateStudent(StudentManager studentManager, Scanner scanner) {
    System.out.print("Enter Student ID to update: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    Student student = studentManager.getStudentById(id);
    if (student != null) {
      System.out.print("Enter new Name: ");
      String name = scanner.nextLine();
      System.out.print("Enter new Age: ");
      int age = scanner.nextInt();
      scanner.nextLine();
      System.out.print("Enter new Grade: ");
      String grade = scanner.nextLine();

      studentManager.updateStudent(id, name, age, grade);
    } else {
      System.out.println("Student not found.");
    }
  }

  private static void deleteStudent(StudentManager studentManager, Scanner scanner) {
    System.out.print("Enter Student ID to delete: ");
    int id = scanner.nextInt();
    Student student = studentManager.getStudentById(id);

    if (student!=null)
      studentManager.deleteStudent(id);
    else
      System.out.println("Student not found.");
  }
}
