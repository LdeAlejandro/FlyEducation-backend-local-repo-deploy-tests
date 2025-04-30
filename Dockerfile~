# Step 1: Build the application using Maven and OpenJDK 21
FROM maven:3.8.4-openjdk-21-slim as builder

# Set working directory
WORKDIR /app

# Copy the pom.xml and the wrapper script
COPY pom.xml ./
COPY mvnw ./
COPY mvnw.cmd ./

# Make sure the mvnw script is executable
RUN chmod +x mvnw

# Download dependencies (this will cache dependencies in Docker layers)
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Step 2: Run the application using OpenJDK 21
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built .jar file from the builder image
COPY --from=builder /app/target/flyflix-0.0.1-SNAPSHOT.jar app.jar

# Expose port for the application
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
