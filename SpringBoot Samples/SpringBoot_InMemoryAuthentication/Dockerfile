# Pull Base Image open JDK 11 
# For smaller size use openjdk:11-alpine
FROM maven:3.6.0-jdk-11-slim AS build
# Run Updates 
RUN apt update
# Copy Dashboard App files into Docker app Dir
COPY . /app
# install Maven and Check Maven Version
#RUN apt install -y maven && mvn -version
# Change to App Dir 
RUN cd /app/ecomdashboard
# Work Dir 
WORKDIR /app/ecomdashboard
# Check is the Correct Dir 
RUN pwd && ls 
# Clean and Install Maven Packages 
#RUN mvn clean package 
# Compile the App and Package the App 
RUN mvn compile && mvn package 
# Check Current Dir and List Content 
RUN pwd && ls 
# Copy the Jar file to dashboard.jar in app Dir 
RUN mv /app/ecomdashboard/target/*.jar /app/dashboard.jar
# Expose the Port 
EXPOSE 8080
# Create CMD to run when the container is run
#CMD ["mvn", "spring-boot:run", "/app/dashboard.jar"]
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/app/dashboard.jar"]