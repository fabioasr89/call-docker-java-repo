# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer=""
# Port expose
EXPOSE 8080
ARG PROFILE=dev
# The application's args
ARG VERSION=0.0.1-SNAPSHOT
# Add the application's jar to the container
ADD target/app-docker-service-$VERSION.jar app-docker-service.jar
# Run the jar file
ENTRYPOINT exec java  \
-Djava.security.egd=file:/dev/./urandom \
-Dspring.profiles.active=dev \
-Xmx1024M -XX:MaxPermSize=512m \
-jar app-docker-service.jar