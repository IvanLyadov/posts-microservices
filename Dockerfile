# Use an official OpenJDK runtime as a base image
FROM openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/posts-microservice-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that the application will run on
EXPOSE 8081

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]