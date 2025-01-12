# Step 1: Use a Gradle image to build the application
FROM gradle:7.3-jdk17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper and project files
COPY . /app/

# Build the JAR file (you can skip tests here to speed up the build process)
RUN gradle clean shadowJar -x test

# Step 2: Use a smaller OpenJDK runtime image to run the app
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage to the runtime image
COPY --from=build /app/build/libs/proto-java-1.0-SNAPSHOT-all.jar /app/proto-java-1.0-SNAPSHOT-all.jar

# Specify the command to run the JAR file
CMD ["java", "-jar", "proto-java-1.0-SNAPSHOT-all.jar"]

# Optionally, expose a port if your app is a web application
EXPOSE 8080
