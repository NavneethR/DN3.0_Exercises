package Week_1_Exercises.Design_Patterns;

import java.util.*;

class Student {
    String id;
    String name;
    String grade;

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

}

class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("Student Details");
        System.out.println("---------------");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
        System.out.println();
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.name = name;
    }

    public String getStudentName() {
        return model.name;
    }

    public void setStudentId(String id) {
        model.id = id;
    }

    public String getStudentId() {
        return model.id;
    }

    public void setStudentGrade(String grade) {
        model.grade = grade;
    }

    public String getStudentGrade() {
        return model.grade;
    }

    public void updateView() {
        view.displayStudentDetails(model.name, model.id, model.grade);
    }
}

public class MVCPatternExample {
    public static void main(String[] args) {
        Student student = new Student("123", "John Doe", "A");
        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        System.out.println("Initial student details:");
        controller.updateView();

        // Initial student details
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("A+");

        // Updated student details
        System.out.println("Updated student details:");
        controller.updateView();
    }
}
