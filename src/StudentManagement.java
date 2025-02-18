import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private ArrayList<Student> students;
    private Scanner scanner;

    // Constructor
    public StudentManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a student
    public void addStudent() {
        try {
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Student ID (6 alphanumeric characters): ");
            String studentId = scanner.nextLine();

            System.out.print("Enter Age (16-100): ");
            int age = scanner.nextInt();

            System.out.print("Enter GPA (0.0 - 4.0): ");
            double gpa = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            Student student = new Student(name, studentId, age, gpa);
            students.add(student);
            System.out.println("Student added successfully!\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // Clear scanner buffer
        }
    }

    // Method to display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.\n");
        } else {
            System.out.println("Student List:");
            for (Student s : students) {
                s.displayStudent();
            }
            System.out.println();
        }
    }

    // Method to delete a student by student ID
    public void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to delete.\n");
            return;
        }

        System.out.print("Enter Student ID to delete: ");
        String studentId = scanner.nextLine();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equalsIgnoreCase(studentId)) {
                students.remove(i);
                System.out.println("Student with ID " + studentId + " has been deleted.\n");
                return;
            }
        }

        System.out.println("Student ID not found.\n");
    }

    // Menu to interact with user
    public void menu() {
        while (true) {
            System.out.println("\nStudent Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        StudentManagement system = new StudentManagement();
        system.menu();
    }
}




