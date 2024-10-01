public class StudentManager {
    private List<Student> studentList;
    private final String FILE_NAME = "students.dat";

    public StudentManager() {
        studentList = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(Student student) {
        studentList.add(student);
        saveToFile();
    }

    public Student(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return " ";
    }

    public void updateStudent(int id, String name, int age, String grade, Student student) {
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            saveToFile();
        }
    }

    public void deleteStudent(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            studentList.remove(student);
            saveToFile();
        }
        else{
            System.out.println(id + " not found.");
        }
    }

    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentList);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentList = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}
