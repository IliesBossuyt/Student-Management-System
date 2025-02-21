package com.example;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private int courseCode;
    private int creditHours;
    private List<Student> students;

    public Course(String courseName, int courseCode, int creditHours) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.students = new ArrayList<>();
    }


    public String getCourseName() {
        return courseName;
    }

    public int getCoursesCode() {
        return courseCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCoursesCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // 🔹 Méthode pour inscrire un étudiant au cours
    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            System.out.println("L'étudiant " + student.getName() + " a été inscrit avec succès au cours " + courseName + ".");
        } else {
            System.out.println("L'étudiant " + student.getName() + " est déjà inscrit à ce cours.");
        }
    }

    // 🔹 Affiche les étudiants inscrits
    public void displayEnrolledStudents() {
        System.out.println("Étudiants inscrits dans le cours " + courseName + " :");
        for (Student student : students) {
            System.out.println(student.getDescription());
        }
    }

    // 🔹 Méthode pour obtenir les détails du cours sous forme de chaîne de caractères
    public String getCourseDetails() {
        return "Course Name: " + courseName + ", Code: " + courseCode + ", Credits: " + creditHours + ", Students Enrolled: " + students.size();
    }
    

        public static void main(String[] args) {
            // 🔹 Création de quelques étudiants
            Student student1 = new Student("Alice", 20, 101, new ArrayList<>(List.of(15.5, 16.0, 14.0)));
            Student student2 = new Student("Bob", 22, 102, new ArrayList<>(List.of(12.0, 14.5, 13.0)));
            Student student3 = new Student("Charlie", 19, 103, new ArrayList<>(List.of(18.0, 17.5, 19.0)));
    
            // 🔹 Création d'un cours
            Course course = new Course("Java Programming", 202, 4);
    
            // 🔹 Inscription des étudiants
            course.enrollStudent(student1);
            course.enrollStudent(student2);
            course.enrollStudent(student3);
            course.enrollStudent(student1); // Test de double inscription (devrait afficher un message)
    
            // 🔹 Affichage des étudiants inscrits
            course.displayEnrolledStudents();
    
            // 🔹 Affichage des détails du cours
            System.out.println(course.getCourseDetails());
    
            // 🔹 Ajouter une nouvelle note à Alice et afficher sa moyenne
            student1.addGrade(18.5);
            System.out.println("Nouvelle moyenne de " + student1.getName() + " : " + student1.calculateAverage());
    }
}
