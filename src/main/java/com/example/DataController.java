package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    private final List<Student> students = new ArrayList<>();

    // 🔹 Initialisation avec 10 étudiants
    public DataController() {
        students.add(new Student("Alice", 20, 101, List.of(15.5, 16.0, 14.0)));
        students.add(new Student("Bob", 22, 102, List.of(12.0, 14.5, 13.0)));
        students.add(new Student("Charlie", 19, 103, List.of(18.0, 17.5, 19.0)));
        students.add(new Student("David", 21, 104, List.of(10.0, 11.5, 9.0)));
        students.add(new Student("Emma", 23, 105, List.of(14.0, 15.0, 16.5)));
        students.add(new Student("Frank", 20, 106, List.of(17.0, 18.0, 16.0)));
        students.add(new Student("Grace", 22, 107, List.of(13.5, 12.0, 14.5)));
        students.add(new Student("Henry", 19, 108, List.of(10.5, 9.5, 11.0)));
        students.add(new Student("Isabelle", 21, 109, List.of(15.0, 16.0, 14.0)));
        students.add(new Student("Jack", 23, 110, List.of(12.5, 13.5, 11.0)));
    }

    // 🔹 Obtenir la liste des étudiants (GET)
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // 🔹 Ajouter un nouvel étudiant (POST)
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Étudiant ajouté avec succès !";
    }

    // 🔹 Modifier un étudiant (PUT)
    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (Student student : students) {
            if (student.getStudentID() == id) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setGrades(updatedStudent.getGrades());
                return "Étudiant mis à jour avec succès !";
            }
        }
        return "Étudiant non trouvé.";
    }

    // 🔹 Supprimer un étudiant (DELETE)
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        students.removeIf(student -> student.getStudentID() == id);
        return "Étudiant supprimé avec succès !";
    }
}
