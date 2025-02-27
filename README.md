Projet Student Management System

Students

Lister tous les étudiants :
GET : http://localhost:8080/api/students/

Récupérer un étudiant par ID :
GET : http://localhost:8080/api/students/{id}

Ajouter un nouvel étudiant :
POST : http://localhost:8080/api/students/
Exemple de corps de requête :

{
  "name": "Jean",
  "age": 20,
  "studentID": 120,
  "grades": [15.5, 16.0, 14.0]
}


Modifier un étudiant :
PUT : http://localhost:8080/api/students/{id}
Exemple de corps de requête :

{
  "name": "Jean Updated",
  "age": 21,
  "studentID": 120,
  "grades": [16.0, 17.0, 15.0]
}


Supprimer un étudiant :
DELETE : http://localhost:8080/api/students/{id}

Calculer la moyenne d'un étudiant :
GET : http://localhost:8080/api/students/{id}/average

Ajouter des notes à un étudiant :
POST : http://localhost:8080/api/students/{id}/add-grades
Corps de la requête (exemple) :

[19.0, 17.5]


--------------------------------------------------------


Courses

Lister tous les cours :
GET : http://localhost:8080/api/courses/

Récupérer un cours par ID :
GET : http://localhost:8080/api/courses/{id}

Ajouter un nouveau cours :
POST : http://localhost:8080/api/courses/
Exemple de corps de requête pour un cours en présentiel :

{
  "courseName": "Advanced Java",
  "coursesCode": 207,
  "creditHours": 5,
  "typeCourses": "Présentiel"
}

Pour un cours en distanciel :

{
  "courseName": "Cloud Computing",
  "coursesCode": 208,
  "creditHours": 4,
  "typeCourses": "Distanciel"
}


Modifier un cours :
PUT : http://localhost:8080/api/courses/{id}
Exemple de corps de requête :

{
  "courseName": "Advanced Java Programming",
  "coursesCode": 202,
  "creditHours": 5,
  "typeCourses": "Présentiel"
}



Supprimer un cours :
DELETE : http://localhost:8080/api/courses/{id}

Créer et ajouter des étudiants à un cours :
POST : http://localhost:8080/api/courses/{id}/enroll-students
Corps de la requête (exemple) :

[
  {
    "name": "Alice",
    "age": 20,
    "studentID": 1,
    "grades": [12.0, 15.0]
  },
  {
    "name": "Bob",
    "age": 22,
    "studentID": 2,
    "grades": [16.0, 10.0]
  }
]


Récupérer les étudiants affectés à un cours :
GET : http://localhost:8080/api/courses/{id}/enrolled


--------------------------------------------------------


Enrollments

Lister toutes les inscriptions :
GET : http://localhost:8080/api/enrollments/

Récupérer une inscription spécifique par index :
GET : http://localhost:8080/api/enrollments/{index}
Remplacez {index} par l'index de l'inscription dans la liste (par exemple, 0, 1, 2, ...).


Lier un étudiant existant à un cours :
POST : http://localhost:8080/api/enrollments/
Corps de la requête (exemple) :

{
  "studentID": 101,
  "coursesCode": 202
}

Cet endpoint associe un étudiant déjà présent dans /api/students à un cours existant (visible dans /api/courses).


Supprimer une inscription :
DELETE : http://localhost:8080/api/enrollments/{index}


--------------------------------------------------------


Utilisez Maven pour compiler et lancer l'application :
mvn clean install

Lancer l'application Spring Boot :
mvn spring-boot:run

L'application démarrera sur le port 8080