# Step 1: Build the application
FROM maven:3.8.4-openjdk-21-slim AS builder

# Set working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .

# Download dependencies (this will cache dependencies in Docker layers)
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application (skip tests for faster build)
RUN mvn clean package -DskipTests

# Step 2: Run the application
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built .jar file from the builder image
COPY --from=builder /app/target/flyflix-0.0.1-SNAPSHOT.jar app.jar

# Expose port for the application
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
