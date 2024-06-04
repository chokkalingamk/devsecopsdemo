# Stage 1: Build the application with Maven
FROM --platform=linux/amd64 maven:3.8.4-openjdk-8 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM --platform=linux/amd64 openjdk:8-jre
WORKDIR /app
COPY --from=build /app/target/docker-java-app-example.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
