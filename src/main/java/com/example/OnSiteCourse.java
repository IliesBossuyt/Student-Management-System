package com.example;

public class OnSiteCourse extends Course {

    public OnSiteCourse() {
        super();
    }

    public OnSiteCourse(String courseName, int courseCode, int creditHours) {
        super(courseName, courseCode, creditHours);
    }

    @Override
    public String getDeliveryMode() {
        return "Présentiel";
    }
}
