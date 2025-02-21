javac -cp "$(cat classpath.txt):target/classes" -d build src/main/java/com/example/*.java
java -cp "$(cat classpath.txt):build" com.example.Course
