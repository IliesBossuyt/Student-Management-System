package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Course;
import com.example.models.Enrollment;
import com.example.models.Student;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    public static List<Enrollment> enrollments = new ArrayList<>();

    // Obtenir la liste des inscriptions (GET)
    @GetMapping("/")
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    // Récupérer une inscription spécifique par son index (GET)
    @GetMapping("/{index}")
    public Object getEnrollment(@PathVariable("index") int index) {
        if (index < 0 || index >= enrollments.size()) {
            return "Inscription non trouvée.";
        }
        return enrollments.get(index);
    }

    // Supprimer une inscription (DELETE)
    @DeleteMapping("/{index}")
    public String deleteEnrollment(@PathVariable("index") int index) {
        if (index < 0 || index >= enrollments.size()) {
            return "Inscription non trouvée.";
        }
        enrollments.remove(index);
        return "Inscription supprimée avec succès.";
    }


    // Lier un étudiant et un cours et inscrire l'étudiant dans le cours
    @PostMapping("/")
    public String registerEnrollment(@RequestBody Map<String, Integer> request) {
        int studentID = request.get("studentID");
        int coursesCode = request.get("coursesCode");
    
        // Rechercher l'étudiant existant
        Student existingStudent = null;
        for (Student s : StudentController.students) {
            if (s.getStudentID() == studentID) {
                existingStudent = s;
                break;
            }
        }
        if (existingStudent == null) {
            return "Étudiant non trouvé.";
        }
    
        // Rechercher le cours existant
        Course existingCourse = null;
        for (Course c : CourseController.courses) {
            if (c.getCoursesCode() == coursesCode) {
                existingCourse = c;
                break;
            }
        }
        if (existingCourse == null) {
            return "Cours non trouvé.";
        }
    
        // Vérifier si l'étudiant est déjà inscrit
        for (Enrollment e : enrollments) {
            if (e.getStudent().getStudentID() == studentID && e.getCourse().getCoursesCode() == coursesCode) {
                return "L'étudiant est déjà inscrit à ce cours.";
            }
        }
    
        // Ajouter l'étudiant au cours (s'il n'y est pas déjà)
        if (!existingCourse.getStudents().contains(existingStudent)) {
            existingCourse.enrollStudent(existingStudent);
        }
    
        // Créer une nouvelle inscription
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(existingStudent);
        enrollment.setCourse(existingCourse);
        
        enrollments.add(enrollment);
    
        return "Étudiant " + existingStudent.getName() + " inscrit avec succès au cours " + existingCourse.getCourseName();
    }    
}
