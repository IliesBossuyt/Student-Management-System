package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CourseController {

    public static List<Course> courses = new ArrayList<>();


    // 🔹 Initialisation des cours
    public CourseController() {
        courses.add(new OnSiteCourse("Java Programming", 202, 4));
        courses.add(new OnlineCourse("Database Management", 203, 3));
        courses.add(new OnlineCourse("Web Development", 204, 5));
        courses.add(new OnSiteCourse("Data Structures", 205, 4));
        courses.add(new OnSiteCourse("Cyber Security Basics", 206, 2));
    }
    

    // 🔹 Obtenir la liste des cours (GET)
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courses;
    }

    // 🔍 Récupérer un cours spécifique par ID (GET)
    @GetMapping("/courses/{id}")
    public Object getCourseById(@PathVariable("id") int id) {
        for (Course course : courses) {
            if (course.getCoursesCode() == id) {
                return course;
            }
        }
        return "Cours non trouvé.";
    }

    // 🔹 Ajouter un nouveau cours (POST)
    @PostMapping("/courses")
    public String addCourse(@RequestBody CourseRequest request) {
        Course newCourse;
        // Création de l'instance concrète selon le deliveryMode fourni
        if ("Présentiel".equalsIgnoreCase(request.getDeliveryMode())) {
            newCourse = new OnSiteCourse(request.getCourseName(), request.getCoursesCode(), request.getCreditHours());
        } else if ("Distanciel".equalsIgnoreCase(request.getDeliveryMode())) {
            newCourse = new OnlineCourse(request.getCourseName(), request.getCoursesCode(), request.getCreditHours());
        } else {
            return "Delivery mode invalide. Utilisez 'Présentiel' ou 'Distanciel'.";
        }
        courses.add(newCourse);
        return "Cours ajouté avec succès : " + newCourse.getCourseName() + " (" + newCourse.getDeliveryMode() + ")";
    }

    // 🔹 Modifier un cours (PUT)
    @PutMapping("/courses/{id}")
    public String updateCourse(@PathVariable("id") int id, @RequestBody CourseRequest updatedRequest) {
        for (int i = 0; i < courses.size(); i++) {
            Course existingCourse = courses.get(i);
            if (existingCourse.getCoursesCode() == id) {
                // Création d'une nouvelle instance de cours selon le deliveryMode fourni
                Course newCourse;
                if ("Présentiel".equalsIgnoreCase(updatedRequest.getDeliveryMode())) {
                    newCourse = new OnSiteCourse(updatedRequest.getCourseName(), updatedRequest.getCoursesCode(), updatedRequest.getCreditHours());
                } else if ("Distanciel".equalsIgnoreCase(updatedRequest.getDeliveryMode())) {
                    newCourse = new OnlineCourse(updatedRequest.getCourseName(), updatedRequest.getCoursesCode(), updatedRequest.getCreditHours());
                } else {
                    return "Delivery mode invalide. Utilisez 'Présentiel' ou 'Distanciel'.";
                }
                // Conserver la liste des étudiants déjà inscrits
                newCourse.setStudents(existingCourse.getStudents());
                // Remplacer l'ancien cours par le nouveau dans la liste
                courses.set(i, newCourse);
                return "Cours mis à jour avec succès !";
            }
        }
        return "Cours non trouvé.";
    }
    

    // 🔹 Supprimer un cours (DELETE)
    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        courses.removeIf(course -> course.getCoursesCode() == id);
        return "Cours supprimé avec succès !";
    }

    // 🔹 Inscrire un étudiant à un cours et l'ajouter à la liste globale
    @PostMapping("/courses/{id}/enroll-students")
    public String enrollStudents(@PathVariable("id") int courseCode, @RequestBody List<Student> studentsList) {
        // Ajout de chaque étudiant à la liste globale partagée
        for (Student student : studentsList) {
            StudentController.students.add(student);
        }
        // Recherche du cours et inscription de chaque étudiant
        for (Course course : courses) {
            if (course.getCoursesCode() == courseCode) {
                for (Student student : studentsList) {
                    course.enrollStudent(student);
                }
                return "Étudiants inscrits avec succès au cours " + course.getCourseName();
            }
        }
        return "Cours non trouvé.";
    }
    

    @GetMapping("/courses/{id}/enrolled")
    public Object getEnrolledStudents(@PathVariable("id") int courseCode) {
        for (Course course : courses) {
            if (course.getCoursesCode() == courseCode) {
                return course.getEnrolledStudents();
            }
        }
        return "Cours non trouvé.";
    }

}
