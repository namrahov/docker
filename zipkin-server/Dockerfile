FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} zipkin-server.jar
ENTRYPOINT ["java","-jar","/zipkin-server.jar"]
EXPOSE 9411