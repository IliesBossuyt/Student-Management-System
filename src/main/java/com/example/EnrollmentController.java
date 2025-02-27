package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EnrollmentController {

    public static List<Enrollment> enrollments = new ArrayList<>();

    // Obtenir la liste des inscriptions (GET)
    @GetMapping("/enrollments")
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    // Récupérer une inscription spécifique par son index (GET)
    @GetMapping("/enrollments/{index}")
    public Object getEnrollment(@PathVariable("index") int index) {
        if (index < 0 || index >= enrollments.size()) {
            return "Inscription non trouvée.";
        }
        return enrollments.get(index);
    }

    // Supprimer une inscription (DELETE)
    @DeleteMapping("/enrollments/{index}")
    public String deleteEnrollment(@PathVariable("index") int index) {
        if (index < 0 || index >= enrollments.size()) {
            return "Inscription non trouvée.";
        }
        enrollments.remove(index);
        return "Inscription supprimée avec succès.";
    }


    // Lier un étudiant et un cours et inscrire l'étudiant dans le cours
    @PostMapping("/enrollments")
    public String registerEnrollment(@RequestBody Enrollment enrollment) {
        // Recherche de l'étudiant existant dans la liste globale
        Student existingStudent = null;
        for (Student s : StudentController.students) {
            if (s.getStudentID() == enrollment.getStudent().getStudentID()) {
                existingStudent = s;
                break;
            }
        }
        if (existingStudent == null) {
            return "Étudiant non trouvé.";
        }
        
        // Recherche du cours existant dans la liste globale des cours
        Course existingCourse = null;
        for (Course c : CourseController.courses) {
            if (c.getCoursesCode() == enrollment.getCourse().getCoursesCode()) {
                existingCourse = c;
                break;
            }
        }
        if (existingCourse == null) {
            return "Cours non trouvé.";
        }
        
        // Utiliser les instances existantes pour l'enrollment
        enrollment.setStudent(existingStudent);
        enrollment.setCourse(existingCourse);
        
        // Inscrire l'étudiant dans le cours s'il n'est pas déjà inscrit
        if (!existingCourse.getStudents().contains(existingStudent)) {
            existingCourse.enrollStudent(existingStudent);
        }
        
        // Enregistrer l'enrollment dans la liste globale des enrollments
        enrollments.add(enrollment);
        
        return "Étudiant " + existingStudent.getName() + " enregistré avec succès pour le cours " + existingCourse.getCourseName();
    } 
}
