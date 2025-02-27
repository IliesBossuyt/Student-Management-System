package com.example.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student extends Person {
    private int studentID;
    private List<Double> grades;

    public Student() {
        super("", 0);
        this.grades = new ArrayList<>();
    }

    public Student(String name, int age, int studentID, List<Double> grades) {
        super(name, age);
        this.studentID = studentID;
        this.grades = new ArrayList<>(grades); 
    }

    public int getStudentID() {
        return studentID;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public void addGrade(Double grade) {
        this.grades.add(grade);
    }

    // Méthode pour calculer la moyenne
    @JsonIgnore
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return (sum / grades.size());
    }
}