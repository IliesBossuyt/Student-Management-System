list all students GET : http://localhost:8080/api/students

average GET : http://localhost:8080/api/students/101/average

add grade POST : http://localhost:8080/api/students/101/add-grades       [19.0, 17.5]




list all courses GET : http://localhost:8080/api/courses

créer et ajouter student a un cour POST : http://localhost:8080/api/courses/enroll-students     [
  {
    "name": "Alice",
    "age": 20,
    "studentID": 1,
    "grades": [85.0, 90.0]
  },
  {
    "name": "Bob",
    "age": 22,
    "studentID": 2,
    "grades": [80.0, 88.0]
  }
]



Recuperer les students affecté a un cours GET : http://localhost:8080/api/courses/202/enrolled



link un étudiant a un cours POST : http://localhost:8080/api/enrollments/register




mvn clean install
mvn spring-boot:run