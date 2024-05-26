# Use a specific Maven base image with OpenJDK 17 for the build stage
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project to the working directory
COPY . .

# Build the application and skip tests to speed up the process
RUN mvn clean install -DskipTests

# Use a specific OpenJDK runtime base image for the final stage
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage to the runtime stage
COPY --from=build /app/target/service-registry.jar demo.jar

# Expose port 8000 to allow external access to the application
EXPOSE 8000

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "demo.jar"]
