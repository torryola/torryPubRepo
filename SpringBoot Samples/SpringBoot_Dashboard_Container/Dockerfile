# Pull Base Image open JDK 11 with Maven 
FROM maven:3.6.0-jdk-11-slim AS build
# Run Updates 
RUN apt update
# Copy Dashboard App files into Docker app Dir
COPY . /app
# Change to App Dir 
RUN cd /app/ecomdashboard
# Work Dir 
WORKDIR /app/ecomdashboard
# Check is the Correct Dir 
RUN pwd && ls 
# Maven clean and Package App to generate jar file 
#RUN mvn clean package 
# Compile the App and Package the App to generate jar file 
#RUN mvn compile && mvn package 
# Move and Rename the Jar file to dashboard.jar in app Dir 
RUN mv /app/ecomdashboard/target/*.jar /app/dashboard.jar
# Expose the Port 
EXPOSE 8080/tcp
# Create CMD to run when the container is run
#CMD ["mvn", "spring-boot:run", "/app/dashboard.jar"]
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/app/dashboard.jar"]