FROM openjdk:17
WORKDIR /app
COPY ./target/todoapp.jar /app
EXPOSE 8080
CMD ["java", "-jar", "todoapp.jar"]