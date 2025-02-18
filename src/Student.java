import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String name;
    private String studentId;
    private int age;
    private double gpa;

    // Constructor calls setter methods for validation
    public Student(String name, String studentId, int age, double gpa) {
        setName(name);
        setStudentId(studentId);
        setAge(age);
        setGpa(gpa);
    }

    // Name validation (must not be empty)
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    // Student ID validation (must be alphanumeric and exactly 6 characters)
    public void setStudentId(String studentId) {
        if (studentId == null || !studentId.matches("[A-Za-z0-9]{6}")) {
            throw new IllegalArgumentException("Student ID must be exactly 6 alphanumeric characters.");
        }
        this.studentId = studentId;
    }

    // Age validation (must be between 16 and 100)
    public void setAge(int age) {
        if (age < 16 || age > 100) {
            throw new IllegalArgumentException("Age must be between 16 and 100.");
        }
        this.age = age;
    }

    // GPA validation (must be between 0.0 and 4.0)
    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
        }
        this.gpa = gpa;
    }

    // Getters
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }

    // Display student information
    public void displayStudent() {
        System.out.println("Student ID: " + studentId + ", Name: " + name + ", Age: " + age + ", GPA: " + gpa);
    }
}
