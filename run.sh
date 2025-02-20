javac -cp "$(cat classpath.txt):target/classes" -d build src/main/java/com/example/Student.java
javac -cp "$(cat classpath.txt):target/classes" -d build src/main/java/com/example/ApiClient.java
java -cp "$(cat classpath.txt):build" com.example.ApiClient
