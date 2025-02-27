package com.example.models;

public class CourseRequest {
    private String courseName;
    private int coursesCode;
    private int creditHours;
    private String TypeCourses;

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
    public String getTypeCourses() {
        return TypeCourses;
    }
    public void setTypeCourses(String TypeCourses) {
        this.TypeCourses = TypeCourses;
    }
}
