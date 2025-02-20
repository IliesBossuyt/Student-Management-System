package com.example;

import java.util.ArrayList;

public class Courses {
    private String courseName;
    private int courseCode;
    private int creditHours;
    private ArrayList<String> students;

    // Initialiser la liste
    public Courses() {
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

    public ArrayList<String> getStudents() {
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

    public void setStudents(ArrayList<String> students) {
        this.students = students;
    }
}
