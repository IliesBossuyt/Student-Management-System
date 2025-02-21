list all : http://localhost:8080/api/students

average : http://localhost:8080/api/students/101/average

add grade : http://localhost:8080/api/students/101/add-grades       [19.0, 17.5]





mvn clean install
mvn spring-boot:run