FROM amazoncorretto:11.0.11-alpine-jdk
MAINTAINER Lucas-Ortega
COPY target/Lucas-Ortega-0.0.1-SNAPSHOT.jar portfolio-app.jar
ENTRYPOINT ["java", "-jar", "/portfolio-app.jar"]
