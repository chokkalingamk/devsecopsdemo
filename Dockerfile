#TODO: Change base image as per the platform
FROM openjdk:17-alpine
ARG HOME_USER=spark
ARG BUILD_PATH=/home/$HOME_USER/app/release
RUN mkdir -p $BUILD_PATH
WORKDIR $BUILD_PATH

#TODO: Modify the source artifact path
# COPY target/hello-maven-1.0-SNAPSHOT.jar app.jar
COPY target/hello-maven-1.0.0.jar app.jar
EXPOSE 8080

#TODO: Modify the entrypoint as per the platform
ENTRYPOINT ["java","-jar","app.jar"]
