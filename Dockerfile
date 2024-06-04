# Stage 1: Build the application with Maven
FROM maven:3.8.4-openjdk-8 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/hello-maven-1.0.0.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
