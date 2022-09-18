FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ticket-service.jar
ENTRYPOINT ["java","-jar","/ticket-service.jar"]
EXPOSE 8502