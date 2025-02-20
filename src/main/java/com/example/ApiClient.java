package com.example;

import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

public class ApiClient {
    private static final String API_URL = "http://localhost:8080/api/students";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Student[] studentsArray = restTemplate.getForObject(API_URL, Student[].class);

        if (studentsArray != null) {
            List<Student> students = Arrays.asList(studentsArray);
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("Aucune donnée reçue !");
        }
    }
}
