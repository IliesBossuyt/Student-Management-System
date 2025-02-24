package com.example;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Course {
    private String courseName;
    private int courseCode;
    private int creditHours;
    private List<Student> students;

    // Constructeur par défaut pour la désérialisation JSON
    public Course() {
        this.students = new ArrayList<>();
    }

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

    // Méthode pour inscrire un étudiant au cours
    public void enrollStudent(Student student) {
        this.students.add(student);
    }

    @JsonIgnore
    public List<Student> getEnrolledStudents() {
        return this.students;
    }

}