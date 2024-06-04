# Stage 1: Build the application with Maven
FROM maven:3.8.4-openjdk-8 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:8-jre
WORKDIR /app
COPY --from=build /app/target/docker-java-app-example.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

# Stage 3: Test the application
FROM maven:3.8.4-openjdk-8 AS test
WORKDIR /app
COPY . .
RUN mvn test