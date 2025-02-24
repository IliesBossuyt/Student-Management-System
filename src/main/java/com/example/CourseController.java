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
        courses.add(new Course("Java Programming", 202, 4));
        courses.add(new Course("Database Management", 203, 3));
        courses.add(new Course("Web Development", 204, 5));
        courses.add(new Course("Data Structures", 205, 4));
        courses.add(new Course("Cyber Security Basics", 206, 2));
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
    public String addCourse(@RequestBody Course course) {
        courses.add(course);
        return "Cours ajouté avec succès !";
    }

    // 🔹 Modifier un cours (PUT)
    @PutMapping("/courses/{id}")
    public String updateCourse(@PathVariable("id") int id, @RequestBody Course updatedCourse) {
        for (Course course : courses) {
            if (course.getCoursesCode() == id) {
                course.setCourseName(updatedCourse.getCourseName());
                course.setCreditHours(updatedCourse.getCreditHours());
                course.setStudents(updatedCourse.getStudents());
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
