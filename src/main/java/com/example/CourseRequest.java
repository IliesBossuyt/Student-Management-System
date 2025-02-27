package com.example;

public class CourseRequest {
    private String courseName;
    private int coursesCode;
    private int creditHours;
    private String deliveryMode; // Valeur attendue : "Présentiel" ou "Distanciel"

    // Getters et setters

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCoursesCode() {
        return coursesCode;
    }
    public void setCoursesCode(int coursesCode) {
        this.coursesCode = coursesCode;
    }
    public int getCreditHours() {
        return creditHours;
    }
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
    public String getDeliveryMode() {
        return deliveryMode;
    }
    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }
}
