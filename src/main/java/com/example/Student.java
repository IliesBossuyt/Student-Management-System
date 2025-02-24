package com.example;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student extends Person {
    private int studentID;
    private List<Double> grades;

    // Constructeur par défaut requis pour la désérialisation JSON
    public Student() {
        super("", 0); // Appel au constructeur de Person avec des valeurs par défaut
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