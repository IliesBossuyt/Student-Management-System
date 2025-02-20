package com.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private int studentID;
    private List<Double> grades;

    // Initialiser la liste
    public Student() {
        this.grades = new ArrayList<>();
    }

    public Student(String name, int age, int studentID, List<Double> grades) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.grades = grades;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentID() {
        return studentID;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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


  public void printGrades() {
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
    }

    // Méthode pour calculer la moyenne
    private double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return (sum / grades.size());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentID=" + studentID +
                ", grades=" + grades +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John");
        student.setAge(20);
        student.setStudentID(123);

        student.addGrade(10.0);
        student.addGrade(15.0);
        student.addGrade(18.0);

        student.printGrades();
    }
}