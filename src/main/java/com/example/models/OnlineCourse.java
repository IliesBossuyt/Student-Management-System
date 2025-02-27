package com.example.models;

public class OnlineCourse extends Course {

    public OnlineCourse() {
        super();
    }

    public OnlineCourse(String courseName, int courseCode, int creditHours) {
        super(courseName, courseCode, creditHours);
    }

    @Override
    public String getTypeCourses() {
        return "Distanciel";
    }
}
