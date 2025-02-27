package com.example.models;

import com.example.controllers.StudentController;

public class Enrollment {
    private Student student;
    private Course course;

    public Enrollment() {}

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }   

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Méthode pour enregistrer l'étudiant au cours
    public void register() {
        // Vérifier que l'étudiant existe déjà dans la liste globale
        boolean found = false;
        for (Student s : StudentController.students) {
            if (s.getStudentID() == student.getStudentID()) {
                found = true;
                student = s;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("L'étudiant avec l'ID " + student.getStudentID() + " n'existe pas.");
        }
        // Associer l'étudiant au cours (s'il n'est pas déjà inscrit)
        if (!course.getStudents().contains(student)) {
            course.enrollStudent(student);
        }
    }  
}
